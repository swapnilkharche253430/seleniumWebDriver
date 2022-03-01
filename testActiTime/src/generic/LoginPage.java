package generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class LoginPage {
	
	WebDriver driver;
	
	//Declaration
	
	@FindBy(name = "username") private WebElement usn;
	@FindBy(name = "pwd") private WebElement psw;
	@FindBy(id  = "loginButton") private WebElement loginBtn;
	@FindBy(xpath = "//img[contains(@src,'timer')]") private WebElement logo;
	@FindBy(id = "keepLoggedInCheckBox") private WebElement keepMeLoggedInCheckBox;
	
	
	//Initialization
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	LoginPage()
	{
		
	}
	
	//Utilization
	
	public WebElement getUsn() {
		return usn;
	}
	
	public WebElement getPsw() {
		return psw;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	public WebElement getLogo() {
		return logo;
	}
	public WebElement getKeepMeLoggedInCheckBox() {
		return keepMeLoggedInCheckBox;
	}
	
	//Operational Methods
	public void sendUsername() {
		usn.sendKeys("admin");
	}
	
	public void sendPassword() {
		psw.sendKeys("manager");
	}
	
	public void clickOnLoginButton() {
		loginBtn.click();
	}

	public void delayOfTwoSeconds() throws InterruptedException {
		Thread.sleep(2000);
	}
	
	//Generic reusable methods
	
	public void validLogin(String validusername,String validpassword) {
		usn.sendKeys(validusername);
		psw.sendKeys(validpassword);
		loginBtn.click();
	}
	
	public void invalidLogin(String invalidusername,String invalidpassword) {
		usn.sendKeys(invalidusername);
		psw.sendKeys(invalidpassword);
		loginBtn.click();
		 
		
		
	}
	public void clear()
	{
		usn.clear();
	}
}