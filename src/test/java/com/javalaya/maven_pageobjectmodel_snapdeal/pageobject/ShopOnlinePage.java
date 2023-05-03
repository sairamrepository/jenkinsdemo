package com.javalaya.maven_pageobjectmodel_snapdeal.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopOnlinePage {

	public WebDriver driver;

	public ShopOnlinePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Search products & brands']")
	private WebElement searchBox;

	@FindBy(xpath = "//span[@class='searchTextSpan']")
	private WebElement clickonSearchIcon;

	@FindBy(xpath = "(//section/div)[2]")
	private WebElement selectFirstProduct;
	
	@FindBy(xpath = "(//section/div)[4]")
	private WebElement selectSecondProduct;

	public ShopOnlinePage clickOnSearch(String anytext) {
		searchBox.clear();
		searchBox.sendKeys(anytext);
		return this;
	}

	public ShopOnlinePage clickSearchIcon() {
		clickonSearchIcon.click();
		return this;
	}

	public ShopOnlinePage clickOnFirstProduct() {
		selectFirstProduct.click();
		return this;
	}

	public ShopOnlinePage clickOnSecondProduct() {
		selectSecondProduct.click();
		return this;
	}
}
