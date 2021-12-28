package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

public class AccountsPageTest extends BaseTest{
	
	@BeforeClass
	public void accPageSetup()
	{
		accPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}
	
	@Test
	public void accountPageTitleTest()
	{
		String title = accPage.accountPageTitle();
		Assert.assertEquals(title,  Constants.ACC_PAGE_TITLE);
	}
	
	@Test
	public void isSearchExistTest()
	{
		Assert.assertTrue(accPage.isSearchExist());
	}
	
	@Test
	public void logoutLinkTest()
	{
		Assert.assertTrue(accPage.logoutLink());
	}
	
	@Test
	public void headersListTest()
	{
		List<String> secHeaderList = accPage.headersList();
		System.out.println(secHeaderList);
		Assert.assertEquals(secHeaderList, Constants.EXP_HEADER_LIST);
	}
	
	@Test
	public void searchTest()
	{
		resultPage = accPage.doSearch("macbook");
		Assert.assertTrue(resultPage.getProductCount()>0);
	}
	
	

}
