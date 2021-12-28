package com.qa.opancart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementsUtil;

public class RegisterationPage {

	// 1. By Locators

	private WebDriver driver;
	private ElementsUtil elementUtil;

	private By firstName = By.name("firstname");
	private By lastName = By.name("lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By cnfrmPassword = By.id("input-confirm");
	private By subscribeYes = By.xpath("(//label[@class='radio-inline'])[position()=1]/input");
	private By subscribeNo = By.xpath("(//label[@class='radio-inline'])[position()=2]/input");
	private By agree = By.name("agree");
	private By submit = By.xpath("//input[@type='submit']");
	private By successMsge = By.xpath("//div[@id='content']/h1");

	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");

	// 2. Constructor

	public RegisterationPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementsUtil(driver);
	}

	public boolean Registeration(String firstName, String lastName, String email, String telephone,
																		String password,String subscribe) 
	{
		fillRegForm(firstName, lastName, email, telephone, password);
		selectSubscription(subscribe);
		selectAgreementAndContinue();
		return getRegisterationStatus();
	}

	public void fillRegForm(String firstName, String lastName, String email, String telephone, String password) {
		elementUtil.doSendKeys(this.firstName, firstName);
		elementUtil.doSendKeys(this.lastName, lastName);
		elementUtil.doSendKeys(this.email, email);
		elementUtil.doSendKeys(this.telephone, telephone);
		elementUtil.doSendKeys(this.password, password);
		elementUtil.doSendKeys(cnfrmPassword, password);
	}

	public void selectSubscription(String subscribe) {
		if (subscribe.equalsIgnoreCase("yes")) {
			elementUtil.doClick(subscribeYes);
		} else {
			elementUtil.doClick(subscribeNo);
		}
	}

	public void selectAgreementAndContinue() {
		elementUtil.doClick(agree);
		elementUtil.doClick(submit);
	}

	public boolean getRegisterationStatus() {
		String message = elementUtil.doGetText(successMsge);
		if (message.contains(Constants.REGISTER_SUCCESS_MESSAGE)) {
			elementUtil.doClick(logoutLink);
			elementUtil.doClick(registerLink);
			return true;
		} else {
			return false;
		}
	}
}
