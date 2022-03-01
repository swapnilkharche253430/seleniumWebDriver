package generic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class HomePage {

	@FindBy(xpath = "//a[@class='logout']") private WebElement logoutLink;
	@FindBy(name="userSelecter.selectedUser") private WebElement enterTimeTrackDropdown;
	@FindBy(id="SubmitTTButton") private WebElement saveLeaveTimeButton;
	
		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		public WebElement getLogoutLink()
		{
			return logoutLink;
		}
		public WebElement getEnterTimeTrackDropdown()
		{
			return enterTimeTrackDropdown;
		}
		
		public WebElement getSaveLeaveTimeButton()
		{
			return saveLeaveTimeButton;
		}
		public void logout()
		{
			logoutLink.click();
		}
		
		
}
