package com.qa.opancart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementsUtil;

public class ProductInfoPage {
	
	private WebDriver driver;
	private ElementsUtil elementUtil;
	
	private By header = By.xpath("//div[@class='cpt_product_description ']//b");
	
	public ProductInfoPage(WebDriver driver)
	{
		this.driver = driver;
		elementUtil = new ElementsUtil(driver);
	}
	
	
	
	

}
