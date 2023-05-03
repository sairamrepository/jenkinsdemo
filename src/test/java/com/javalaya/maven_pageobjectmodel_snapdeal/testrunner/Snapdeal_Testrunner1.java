package com.javalaya.maven_pageobjectmodel_snapdeal.testrunner;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.javalaya.maven_pageobjectmodel_snapdeal.pageobject.ShopOnlinePage;
import com.javalaya.maven_pageobjectmodel_snapdeal.utility.BrowserFactory;
import com.javalaya.maven_pageobjectmodel_snapdeal.utility.CommonUtility;

public class Snapdeal_Testrunner1 {

	private String bn, url;
	private WebDriver driver;

	@BeforeSuite
	public void loadData() {
		CommonUtility.readPropertiesfiles(new File("snapdeal_testdata"));
		System.out.println(CommonUtility.allData);
	}

	@AfterMethod
	public void closure() {
		BrowserFactory.closeAllBrowsers();
	}

	@Parameters({ "browsername" })
	@BeforeTest
	public void readProperties(String bn) {
		this.bn = bn;
	}

	@BeforeMethod
	public void openUrl() {
		url = CommonUtility.allData.get("applicationurl");

		driver = BrowserFactory.getBrowser(bn);
		BrowserFactory.launchApplication(url);
	}

	@Test
	public void verifySnapdealTitle() {
		String expected_output = "Shop Online for Men, Women & Kids Clothing, Shoes, Home Decor Items";
		String actual_output = driver.getTitle();

		Assert.assertEquals(actual_output, expected_output, "Title Matched");
	}

	@Test
	public void verifySnapdealTitle2() {

		String req = CommonUtility.allData.get("shoponlinepage.givereq");
		System.out.println(req);

		ShopOnlinePage sop = new ShopOnlinePage(driver);
		sop.clickOnSearch(req);
		sop.clickSearchIcon();

		String expected_output = "Snapdeal.com - Online shopping India- Discounts - shop Online Perfumes, Watches, sunglasses etc";
		String actual_output = driver.getTitle();
		System.out.println(actual_output);

		Assert.assertEquals(actual_output, expected_output, "Title Matched");
	}
}
