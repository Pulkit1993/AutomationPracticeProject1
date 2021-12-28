package com.qa.opancart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementsUtil;

public class LoginPage {
	
	// 1: private By Locators
	
	private WebDriver driver;
	private ElementsUtil elementUtil;
	
	By emailId = By.id("input-email");
	By password = By.id("input-password");
	By loginButton = By.xpath("//input[@value='Login']");
	By forgotPwd = By.linkText("Forgotten Password");
	By registerLink = By.linkText("Register");
	
	// 2: Constructor 
	
	 public LoginPage(WebDriver driver)
	 {
		 this.driver = driver;
		 elementUtil = new ElementsUtil(driver);
	 }
	 
	 // 3. page actions//methods
	 
	 public String getTitle()
	 {
		 return driver.getTitle();
	 }
	 
	 public String getLoginPageUrl()
	 {
		 return driver.getCurrentUrl();
	 }
	 
	 public boolean isForgotPwdLinkExist()
	 {
		 return elementUtil.doIsDisplayed(forgotPwd);
	 }
	 
	 public boolean isRegisterLinkExist()
	 {
		 return elementUtil.doIsDisplayed(registerLink);
	 }
	 
	 public AccountsPage doLogin(String un, String pwd)
	 {
		 elementUtil.doSendKeys(emailId, un);
		 elementUtil.doSendKeys(password, pwd);
		 elementUtil.doClick(loginButton);
		 return new AccountsPage(driver);
	 }
	 
	 public RegisterationPage navigateToRegisterPage()
	 {
		 elementUtil.doClick(registerLink);
		 return new RegisterationPage(driver);
	 }
	 
}
