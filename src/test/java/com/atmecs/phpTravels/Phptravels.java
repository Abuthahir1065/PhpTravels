package com.atmecs.phpTravels;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
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
import helper.HelperClass;
import pageActions.PhpTravelsClass;

public class Phptravels extends SetUp{
@Test
	public void runPhpTravels() throws InterruptedException
	{
		PhpTravelsClass run=new PhpTravelsClass();
		run.loginSite();
		
	}
}
