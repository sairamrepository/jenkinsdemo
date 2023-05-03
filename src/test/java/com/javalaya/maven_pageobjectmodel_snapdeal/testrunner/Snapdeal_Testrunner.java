package com.javalaya.maven_pageobjectmodel_snapdeal.testrunner;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.javalaya.maven_pageobjectmodel_snapdeal.pageobject.ShopOnlinePage;
import com.javalaya.maven_pageobjectmodel_snapdeal.utility.BrowserFactory;
import com.javalaya.maven_pageobjectmodel_snapdeal.utility.CommonUtility;

public class Snapdeal_Testrunner {

	private WebDriver driver;

	@Test
	public void loadTestData() {

//		CommonUtility.readPropertiesfiles("snapdeal_testconfig");
//		System.out.println(CommonUtility.allData);

		CommonUtility.readPropertiesfiles(new File("snapdeal_testdata"));
		System.out.println(CommonUtility.allData);

		String bn = CommonUtility.allData.get("browsername");
		String url = CommonUtility.allData.get("applicationurl");

		driver = BrowserFactory.getBrowser(bn);
		BrowserFactory.launchApplication(url);

		String req = CommonUtility.allData.get("shoponlinepage.givereq");

		ShopOnlinePage sop = new ShopOnlinePage(driver);
		sop.clickOnSearch(req);

//		sop.clickSearchIcon();

//		sop.clickOnTshirt();

//		int windowCount = DriverUtility.windowCount(driver);

//		DriverUtility.switchtoWindow(driver, windowCount);

//		BuyProductPage bpp = new BuyProductPage(driver);
//		bpp.buyNowOption();
//		bpp.checkButton();

//		ProductPage pp = new ProductPage(driver);
//		pp.clickOnAddToCart();
//		pp.clickOnSizeChart();
		BrowserFactory.closeAllBrowsers();
	}

	@Test
	public void loadTestData2() {

		CommonUtility.readPropertiesfiles(new File("snapdeal_testdata"));
		System.out.println(CommonUtility.allData);
		
		
		String bn = CommonUtility.allData.get("browsername");
		String url = CommonUtility.allData.get("applicationurl");

		driver = BrowserFactory.getBrowser(bn);
		BrowserFactory.launchApplication(url);

		String expected_output = "Shop Online for Men, Women & Kids Clothing, Shoes, Home Decor Items";
		String actual_output = driver.getTitle();

		Assert.assertEquals(actual_output, expected_output, "Title Matched");

		BrowserFactory.closeAllBrowsers();
	}

	@Test
	public void loadTestData3() {

		
		CommonUtility.readPropertiesfiles(new File("snapdeal_testdata"));
		System.out.println(CommonUtility.allData);

		String bn = CommonUtility.allData.get("browsername");
		String url = CommonUtility.allData.get("applicationurl");

		driver = BrowserFactory.getBrowser(bn);
		BrowserFactory.launchApplication(url);

		String req = CommonUtility.allData.get("shoponlinepage.givereq");

		ShopOnlinePage sop = new ShopOnlinePage(driver);
		sop.clickOnSearch(req);
		sop.clickSearchIcon();
		
		String expected_output = "Snapdeal.com - Online shopping India- Discounts - shop Online Perfumes, Watches, sunglasses etc";
		String actual_output = driver.getTitle();
		System.out.println(actual_output);

		Assert.assertEquals(actual_output, expected_output, "Title Matched");

		BrowserFactory.closeAllBrowsers();
		
	}
}
