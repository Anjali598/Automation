package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage {

	@FindBy(id="username")
	private WebElement unTb;
	@FindBy(name="pwd")
	private WebElement pwTb;
	@FindBy(xpath="//div[.='Login ']")
	private WebElement loginBtn;
	@FindBy(xpath="//span[contains(.,'Invalid']")
	private WebElement errMsg;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setUserName(String un) {
	    unTb.sendKeys(un);
	}

	public void setPassword(String pw) {
		pwTb.sendKeys(pw);
	}

	public void clickLoginBtn() {
		loginBtn.click();
	}

	public void verifyErrMsgIsDisplayed(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,10);
		try {
			wait.until(ExpectedConditions.visibilityOf(errMsg));
			Reporter.log("Error Message is Dispalyed",true);
		}catch(Exception e) {
			Reporter.log("Error Message is Not Dispalyed",true);
			Assert.fail();
		}
		
	}
	
}
