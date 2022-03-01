package generic;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.google.common.io.Files;

public class BaseTest implements IAutoConstant {
	
	 protected static WebDriver driver;
	@BeforeMethod
	public void openBrowser() throws IOException
	{
		Flib flib = new Flib();
		String browserValue = flib.readPropertyData(PROP_PATH,"browser");
		String url = flib.readPropertyData(PROP_PATH,"url");
	//	System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		
		 if (browserValue.equals("firefox"))
		{
			System.setProperty(GECKO_KEY, GECKO_PATH);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
			driver.get(url);
		} 
		else if(browserValue.equals("chrome"))
		{
			System.setProperty(CHROME_KEY, CHROME_PATH);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
			driver.get(url);
		}
		
		
		else 
		{
			System.out.println("Invalid Option");
		}
}
		@AfterMethod
		public void closeBrowser()
		{
			driver.quit();
			SoftAssert sf= new SoftAssert();
			sf.assertAll();
			
			
		}
		
		public void failed(String name) throws IOException
		{
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File("./screenshots/"+name+".png");
			Files.copy(src,dest);
		}
}







