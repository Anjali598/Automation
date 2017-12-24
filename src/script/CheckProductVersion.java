package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.EnterTimeTrackPage;
import page.LoginPage;

public class CheckProductVersion extends BaseTest{

	@Test(priority=3,groups="version")
	public void testCheckProductVersion() {
		String sheet="CheckProductVersion";
		String un=Excel.getCellValue(XL_PATH, sheet, 1, 0);
		String pw=Excel.getCellValue(XL_PATH, sheet, 1, 1);
		String eVersion=Excel.getCellValue(XL_PATH, sheet, 1, 2);
		
		LoginPage l=new LoginPage(driver);
		l.setUserName(un);
		l.setPassword(pw);
		l.clickLoginBtn();
		
		EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		e.clickHelp();
		
		e.clickAboutActiTime();
		e.verifyVersion(eVersion);
		
		e.clickClose();
		e.clickLogOut();
		
	}
}
