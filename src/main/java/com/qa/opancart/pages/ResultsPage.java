package com.qa.opancart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementsUtil;

public class ResultsPage {
	
	// By Locators
	private WebDriver driver;
	private ElementsUtil elementUtil;
	
	By searchHeader = By.xpath("//div[@id='content']/h1");
	By productsList = By.xpath("//div[@class='caption']//a");
	
	public ResultsPage(WebDriver driver)
	{
		this.driver = driver;
		elementUtil = new ElementsUtil(driver);
	}
	
	public String searchHeader()
	{
		return elementUtil.doGetText(searchHeader);
	}
	
	public int  getProductCount()
	{
		return elementUtil.waitForElementsVisible(productsList, Constants.DEFAULT_TIME_OUT).size();
	}
	
	public ProductInfoPage selectMainProduct(String mainProductName)
	{
		List<WebElement> searchList = elementUtil.waitForElementsVisible(productsList, Constants.DEFAULT_TIME_OUT);
		for(WebElement e: searchList)
		{
			String text = e.getText().trim();
			if(text.equals("MacBook Pro"))
			{
				e.click();
				break;
			}
		}
		return new ProductInfoPage(driver);
	}
	
	

}
