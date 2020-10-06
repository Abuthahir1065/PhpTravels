
package browser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import constant.Constant;
import reader.PropertyReader;

public class SetUp {

	public static WebDriver driver;
	public static Properties properties;

	@BeforeMethod

	public void browserSetUp() {

		System.setProperty("webdriver.chrome.driver", Constant.CHROME_PATH);

		driver = new ChromeDriver();
		
		
		driver.get("https://phptravels.com/");
		String actualTitle=driver.getTitle();
		
		String expectedTitle="PHPTRAVELS booking script and system for hotels airline flights tours cars online application - PHPTRAVELS";
		Assert.assertEquals(actualTitle, expectedTitle);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
