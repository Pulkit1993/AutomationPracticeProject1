package com.qa.opencart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ExcelUtil;

public class RegisterationPageTest extends BaseTest {
	
	@BeforeClass
	public void registerationPageSetup()
	{
		regPage = loginPage.navigateToRegisterPage();
	}
	
	public void getEmail()
	{
		Random random = new Random();
	
	}
	
	@DataProvider
	public Object[][] getRegPageData()
	{
		Object data[][]= ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		return data;
	}
	
	@Test(dataProvider= "getRegPageData")
	public void RegisterationTest(String firstname, String lastname, String email, String telephone,
																		String password, String subscribe)
	{
		Assert.assertTrue(regPage.Registeration(firstname, lastname, email, telephone, password, subscribe));
	}

}
