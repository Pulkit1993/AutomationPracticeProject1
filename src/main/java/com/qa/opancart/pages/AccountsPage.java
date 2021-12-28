package com.qa.opancart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementsUtil;

public class AccountsPage {
	
	// 1. By Locators
	
	private WebDriver driver;
	private ElementsUtil elementUtil;
	
	By search = By.name("search");
	By logoutLink = By.linkText("Logout");
	By headers = By.xpath("//div[@id='content']/h2");
	By searchButton = By.xpath("//span[@class='input-group-btn']");
	
	
	//2. Constructor
	
	public AccountsPage(WebDriver driver)
	{
		this.driver = driver;
		elementUtil = new ElementsUtil(driver);
	}
	
	// 3. Actions
	
	public String accountPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean isSearchExist()
	{
		return driver.findElement(search).isDisplayed();
	}
	
	public boolean logoutLink()
	{
		return driver.findElement(logoutLink).isDisplayed();
	}
	
	public List<String> headersList()
	{
		List<WebElement> headersList = driver.findElements(headers);
		List<String> secHeaderList = new ArrayList<String>();
		for(WebElement e: headersList)
		{
			secHeaderList.add(e.getText());
		}
		return secHeaderList;
	}
	
	public ResultsPage doSearch(String productName)
	{
		elementUtil.doSendKeys(search, productName);
		elementUtil.doClick(searchButton);
		return new ResultsPage(driver);
	}


}
