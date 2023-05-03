package com.javalaya.maven_pageobjectmodel_snapdeal.testrunner;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.javalaya.maven_pageobjectmodel_snapdeal.pageobject.ProductPage;
import com.javalaya.maven_pageobjectmodel_snapdeal.pageobject.ShopOnlinePage;
import com.javalaya.maven_pageobjectmodel_snapdeal.utility.BrowserFactory;
import com.javalaya.maven_pageobjectmodel_snapdeal.utility.CommonUtility;
import com.javalaya.maven_pageobjectmodel_snapdeal.utility.DriverUtility;

public class Snapdeal_Testrunner4 {

	private WebDriver driver;
	private String bn, url;

	@BeforeSuite(groups = {"low","medium","high"})
	public void loadData() {
		CommonUtility.readPropertiesfiles(new File("snapdeal_testdata"));
		System.out.println(CommonUtility.allData);
	}

	@AfterMethod(groups = {"low","medium","high"})
	public void close() {
		BrowserFactory.closeAllBrowsers();
	}

	@Parameters({ "brname" })
	@BeforeTest(groups = {"low","medium","high"})
	public void readPro(@Optional("chrome") String bn) {
		this.bn = bn;
	}

	@BeforeMethod(groups = {"low","medium","high"})
	public void openUrl() {
		url = CommonUtility.allData.get("applicationurl");

		driver = BrowserFactory.getBrowser(bn);
		BrowserFactory.launchApplication(url);
	}

	@Test(groups = {"high"})
	public void verifyfirsttest() {

		String input = CommonUtility.allData.get("shoponlinepage.selectmug");

		ShopOnlinePage sp = new ShopOnlinePage(driver);
		sp.clickOnSearch(input);
		sp.clickSearchIcon();

		sp.clickOnFirstProduct();

		int windowCount = DriverUtility.windowCount(driver);

		DriverUtility.switchtoWindow(driver, windowCount);

		ProductPage ppn = new ProductPage(driver);
		ppn.clickOnAddToCart();

//		ppn.clickOnSizeChart();

		ppn.checkCart();

		ppn.itemsInCart();

		int expected_value = 1;
		int actual_value = ppn.itemsInCart();

		System.out.println(actual_value);

		Assert.assertEquals(actual_value, expected_value);
	}
	
	@Test(groups = {"low","medium"})
	public void verifysecondTest() {
		
		String input = CommonUtility.allData.get("shoponlinepage.selectmug");

		ShopOnlinePage sp = new ShopOnlinePage(driver);
		sp.clickOnSearch(input);
		sp.clickSearchIcon();

		sp.clickOnFirstProduct();

		int windowCount = DriverUtility.windowCount(driver);
		DriverUtility.switchtoWindow(driver, windowCount);

		ProductPage ppn = new ProductPage(driver);
		ppn.clickOnAddToCart();
		
		ppn.checkCart();

		ppn.itemsInCart();
		
		int windowCount2 = DriverUtility.windowCount(driver);
		DriverUtility.switchtoWindow(driver, windowCount2-1);

		sp.clickOnSecondProduct();
		
		int newwindowCount = DriverUtility.windowCount(driver);
		DriverUtility.switchtoWindow(driver, newwindowCount);
		
		ppn.clickOnAddToCart();
		
		ppn.checkCart();
		
		ppn.itemsInCart();
		
		int expected_value1=2;
		int actual_value1 = ppn.itemsInCart();
		System.out.println(actual_value1);
		
		Assert.assertEquals(actual_value1, expected_value1); 
		System.out.println("This is Verify First Test Case");
	}
}
