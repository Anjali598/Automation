package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.EnterTimeTrackPage;
import page.LoginPage;

public class ValidLogin extends BaseTest {

	@Test(priority=1 , groups="smoke")
	public void testValidLogin() {
		
		String un=Excel.getCellValue(XL_PATH, "ValidLogin", 1, 0);
		String pw=Excel.getCellValue(XL_PATH, "ValidLogin", 1, 1);
		String eTitle=Excel.getCellValue(XL_PATH, "ValidLogin", 1, 2);
		
		//Eneter Valid UserName
		
		LoginPage l=new LoginPage(driver);
		l.setUserName(un);
		l.setPassword(pw);
		l.clickLoginBtn();
		
		EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		e.verifyTitle(driver,eTitle);
		
	}
	
}
