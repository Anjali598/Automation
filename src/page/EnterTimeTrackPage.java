package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class EnterTimeTrackPage {

	@FindBy(xpath="//div[contains(text(),'Help')]")
	private WebElement help;
	
	@FindBy(linkText="About your actiTIME")
	private WebElement aboutActiTime;
	
	@FindBy(xpath="//span[starts-with(.,'actiTIME')]")
	private WebElement productVersion;
	
	@FindBy(id="aboutPopupCloseButtonId")
	private WebElement closeBtn;
	
	@FindBy(id="logoutLink")
	private WebElement logoutLink;
	
	public EnterTimeTrackPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		public void clickHelp() {
			help.click();
		}
		public void clickAboutActiTime() {
			aboutActiTime.click();
	}
   public void verifyVersion(String eVersion) {
	 String aVersion=productVersion.getText();
	 Assert.assertEquals(aVersion, eVersion);
   }
   public void clickClose() {
	   closeBtn.click();
   }
   public void clickLogOut() {
	logoutLink.click();
   }
   public void verifyTitle(WebDriver driver, String eTitle) {
	   WebDriverWait wait=new WebDriverWait(driver, 10);
	   try {
		   wait.until(ExpectedConditions.titleIs(eTitle));
		   Reporter.log("Title is Matching",true);
	   }catch(Exception e) {
		   Reporter.log("Title is Not Matching",true);
		   Assert.fail();
	   }
   }
}
