package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.LoginPage;

public class InvalidLogin extends BaseTest{

	@Test(priority=2,groups="Login")
	public void testInvalidLogin() {
		String un=Excel.getCellValue(XL_PATH, "InvalidLogin", 1, 0);
		String pw=Excel.getCellValue(XL_PATH, "InvalidLogin", 1, 1);
		
		LoginPage l=new LoginPage(driver);
		l.setUserName(un);
		l.setPassword(pw);
		l.clickLoginBtn();
		l.verifyErrMsgIsDisplayed(driver);
	}
}
