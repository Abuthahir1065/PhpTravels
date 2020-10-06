package pageActions;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import browser.SetUp;
import constant.Constant;
import helper.HelperClass;
import reader.PropertyReader;

public class PhpTravelsClass extends SetUp {

	Properties Location_path, Data_path;

	public void loginSite() throws InterruptedException {
		Logger log = Logger.getLogger(PhpTravelsClass.class);

		Location_path = PropertyReader.readProperty(Constant.LOCATOR_FILE_PATH);
		Data_path = PropertyReader.readProperty(Constant.DATA_FILE_PATH);
		log.info("Switching to iframe");
		WebElement widget = driver.findElement(By.id(Location_path.getProperty("Frame_Id")));
		widget.click();
		widget.isDisplayed();
		log.info("Chat-Widget Dispalayed...Assertion Passed");
		driver.switchTo().frame(Location_path.getProperty("Frame_Id"));

		WebDriverWait wait = new WebDriverWait(driver, 40);
		log.info("ChatWidget Displayed");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Location_path.getProperty("ChatWidget"))));
		log.info("ChatWidget Clicked");

		HelperClass.jsClick(driver, Location_path.getProperty("ChatWidget"));
		log.info("Sending Name");
		HelperClass.sendKeyById(driver, Location_path.getProperty("NameData"), Data_path.getProperty("Name"));
		log.info("Sending WhatsApp Number");
		HelperClass.ElementSendKeys(driver, Location_path.getProperty("WhatsApp"), Data_path.getProperty("WhatsAppNo"));
		log.info("Sending Email");
		HelperClass.sendKeyById(driver, Location_path.getProperty("EmailData"), Data_path.getProperty("Email"));

		HelperClass.selectFromDropDown(driver, Location_path.getProperty("Dropdown"),
				Location_path.getProperty("value"));
		log.info("Chat has been Started");
		HelperClass.jsClick(driver, Location_path.getProperty("StartChat"));

	}

}
