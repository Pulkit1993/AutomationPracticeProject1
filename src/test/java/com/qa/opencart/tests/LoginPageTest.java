package com.qa.opencart.tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

public class LoginPageTest extends BaseTest
{
	@Test
	public void getTitleTest()
	{
		String title = loginPage.getTitle();
		System.out.println("Login Page Title is " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test
	public void getLoginPageUrlTest()
	{
		String url = loginPage.getLoginPageUrl();
		Assert.assertTrue(url.contains(Constants.LOGIN_PAGE_URL));
	}
	
	@Test
	public void isForgotPwdLinkExistTest()
	{
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	@Test
	public void isRegisterLinkExistTest()
	{
		Assert.assertTrue(loginPage.isRegisterLinkExist());
	}
	
	@Test(priority =1)
	public void doLoginTest()
	{
		loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}
}