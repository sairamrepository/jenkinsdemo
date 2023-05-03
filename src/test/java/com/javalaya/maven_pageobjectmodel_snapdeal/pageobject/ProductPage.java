package com.javalaya.maven_pageobjectmodel_snapdeal.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	public WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath = "(//div/span[@class='intialtext'])[1]")
	private WebElement addToCart;
	
	@FindBy(xpath = "//a[@class='view-size-chart']")
	private WebElement size;
	
	@FindBy(xpath = "//span[@class='cartQuantity']")
	private WebElement cartQ;
	
	@FindBy(xpath = "(//span[text()=1])[1]")
	private WebElement itemsinCart;
	
//	@FindBy(xpath = "//span[text()='(1 Item)']")
//	private WebElement checkCartItems;
	
	@FindBy(xpath = "//ul[@class=\"clearfix\"]/li")
	private List<WebElement> checkCartItemsp;
	
	
	public ProductPage clickOnAddToCart() {
		addToCart.click();
		return this;
	}
	
	public ProductPage clickOnSizeChart() {
		size.click();
		System.out.println(size.getText());
		return this;
	}
	
	public ProductPage checkCart() {
		cartQ.click();
		return this;
	}
	
	public int itemsInCart() {
	return checkCartItemsp.size();
	}
	

}
