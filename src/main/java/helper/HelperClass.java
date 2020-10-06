package helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import browser.SetUp;

public class HelperClass extends SetUp {
	static Logger logger = Logger.getLogger(HelperClass.class);

	static WebDriver driver;

	public HelperClass(WebDriver driver) {
		this.driver = driver;
	}

	public static void ElementSendKeys(WebDriver driver, String xpath, String key) {

		WebElement element = driver.findElement(By.xpath(xpath));
		element.sendKeys(key);
		Assert.assertEquals(true, element.isEnabled());
		logger.info("Element Enabled...Assertion passed");

		//System.out.println("Element Enabled...Assertion passed");
	}

	public static void sendKeyById(WebDriver driver, String idPath, String key)

	{

		WebElement element = driver.findElement(By.id(idPath));
		element.sendKeys(key);
		Assert.assertTrue(element.isEnabled());
		//System.out.println("Element Enabled...Assertion passed");
		logger.info("Element Enabled...Assertion passed");

	}

	public static void selectFromDropDown(WebDriver driver, String xpath, String value) {
		Select choose = new Select(driver.findElement(By.xpath(xpath)));

		choose.selectByValue(value);

	}

	public static void jsClick(WebDriver driver, String xpath) {
		// TODO Auto-generated method stub
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement button = driver.findElement(By.xpath(xpath));

		js.executeScript("arguments[0].click();", button);

	}

}
