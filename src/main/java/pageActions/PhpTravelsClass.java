package pageActions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.errorprone.annotations.Var;

import browser.SetUp;
import constant.Constant;
import helper.HelperClass;
import reader.PropertyReader;

public class PhpTravelsClass extends SetUp {

	Properties Location_path, Data_path;

	
	public void loginSite() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		Location_path=PropertyReader.readProperty(Constant.LOCATOR_FILE_PATH);
		Data_path=PropertyReader.readProperty(Constant.DATA_FILE_PATH);
		
		
		driver.switchTo().frame(Location_path.getProperty("Frame_Id"));
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Location_path.getProperty("ChatWidget"))));

        HelperClass.jsClick(driver, Location_path.getProperty("ChatWidget"));
        HelperClass.sendKeyById(driver, Location_path.getProperty("Name"), Data_path.getProperty("Name"));
        HelperClass.ElementSendKeys(driver, Location_path.getProperty("WhatsApp"), Data_path.getProperty("WhatsAppNo"));
        HelperClass.sendKeyById(driver, Location_path.getProperty("Email"), Data_path.getProperty("Email"));

        HelperClass.selectFromDropDown(driver, Location_path.getProperty("Dropdown"), Location_path.getProperty("value"));
	
        HelperClass.jsClick(driver, Location_path.getProperty("StartChat"));

	
		driver.switchTo().defaultContent();

	}

	

}
