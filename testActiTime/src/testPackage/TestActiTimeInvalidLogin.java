
package testPackage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.CustomListener;
import generic.Flib;
import generic.IAutoConstant;
import generic.LoginPage;

@Listeners(CustomListener.class)
public class TestActiTimeInvalidLogin  extends BaseTest  {
	
	
	@Test
	public void invalidLogin() throws IOException, InterruptedException {
		
		BaseTest bt = new BaseTest();
	
		LoginPage lp = new LoginPage(driver);
	
		Flib flib = new Flib();
		
		int rc= flib.getRowCount(EXCEL_PATH, "invalidCreds");
		
		 for(int i=1;i<rc;i++)
		 {
		  String username = flib.readExcelData(EXCEL_PATH, "invalidcreds",i,0);
		 
		 String password = flib.readExcelData(EXCEL_PATH,"invalidcreds",i,1);
		 
		 lp.invalidLogin(username, password);
		 
		
		 WebElement msg = driver.findElement(By.xpath("//span[.='Username or Password is invalid. Please try again.']"));
		 String text = msg.getText();
		 // System.out.println(text); 
		
			SoftAssert softassert = new SoftAssert();
			softassert.assertEquals(text, "Username or Password is invalid. Please try againnn.");

		 lp.clear();
		 
			
		 }
		 
	}
}

	
	
	