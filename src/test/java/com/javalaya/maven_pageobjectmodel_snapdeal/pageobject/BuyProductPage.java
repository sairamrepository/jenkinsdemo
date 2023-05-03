package com.javalaya.maven_pageobjectmodel_snapdeal.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuyProductPage {

	public WebDriver driver;

	public BuyProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = "//div[@id='add-cart-button-id']")
	private WebElement clickaddtoCart;
	
	public BuyProductPage clickOnAddToCart() {
		clickaddtoCart.click();
		return this;
	}
	
//	@FindBy(xpath = "//i[@class='sd-icon sd-icon-like-outline heart-icon animated-font-pre']")
//	private WebElement favIcon;
	
	
	@FindBy(xpath = "//span[text()='check']")
	private WebElement check;
	
	public BuyProductPage checkButton() {
		check.click();
		return this;
	}

//	public void addToCart() {
//		WebElement add = driver.findElement(By.xpath("//span[text()='add to cart']"));
//		add.click();
//	}

//	public BuyProductPage clickOnAddToCart() {
//		FluentWait<WebDriver>wait = new FluentWait<WebDriver>(driver);
//		wait.withTimeout(Duration.ofSeconds(180));
//		wait.pollingEvery(Duration.ofSeconds(5));
//		wait.ignoring(StaleElementReferenceException.class);
//		WebElement addtoCart = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='add to cart']")));
//		clickaddtoCart.click();
//		addtoCart.click();
//		return this;
//	}
	
//	public BuyProductPage addToFav() {
//		favIcon.click();
//		return this;
//	}
	
	public BuyProductPage buyNowOption() {
		WebElement add = driver.findElement(By.xpath("//span[normalize-space()='buy now']"));
		add.click();
		return this;
	}
		
}
