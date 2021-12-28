package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opancart.pages.AccountsPage;
import com.qa.opancart.pages.LoginPage;
import com.qa.opancart.pages.RegisterationPage;
import com.qa.opancart.pages.ResultsPage;
import com.qa.opencart.factory.DriverFactory;

public class BaseTest {
	
	WebDriver driver;
	public DriverFactory df;
	public Properties prop;
	public LoginPage loginPage;
	public AccountsPage accPage;
	public ResultsPage resultPage;
	public RegisterationPage regPage;
	
	@BeforeTest
	public void setUp()
	{
		df= new DriverFactory();
		prop = df.initProp();
		driver = df.initBrowser(prop);
		loginPage = new LoginPage(driver);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
