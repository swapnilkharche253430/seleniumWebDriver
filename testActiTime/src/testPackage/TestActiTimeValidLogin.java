package testPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.CustomListener;
import generic.Flib;
import generic.LoginPage;
import generic.WebDriverCommonLib;

@Listeners(CustomListener.class)
public class TestActiTimeValidLogin extends BaseTest {

	@Test
	public void login() throws IOException {
		LoginPage lp = new LoginPage(driver);

		Flib flib = new Flib();
		String ValidUsername = flib.readPropertyData(PROP_PATH, "usn");
		String ValidPassword = flib.readPropertyData(PROP_PATH, "psw");

		lp.validLogin(ValidUsername, ValidPassword);

		WebDriverCommonLib wb = new WebDriverCommonLib();
		String ActualHomePageTitle = wb.getTheTitleOfTheWebPage();
		
		Assert.assertEquals(ActualHomePageTitle, "actiTIME - Enter Time-Track");
		

	}

}
