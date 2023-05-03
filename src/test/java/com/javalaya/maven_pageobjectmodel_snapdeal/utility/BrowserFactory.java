package com.javalaya.maven_pageobjectmodel_snapdeal.utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	public static WebDriver driver;

	private static void openChrome() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(option);
	}

	private static void openFirefox() {
		driver = new FirefoxDriver();
	}

	private static void openEdge() {
		driver = new EdgeDriver();
	}

	public static WebDriver getBrowser(String browserName) {
		// if (driver == null) {
		switch (browserName.intern().toLowerCase()) {
		case "chrome":
			openChrome();
			break;
		case "firefox":
			openFirefox();
			break;
		case "edge":
			openEdge();
			break;
//			}
		}
		return driver;
	}

	public static void launchApplication(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public static void closeAllBrowsers() {
		driver.close();
		driver.quit();
	}
}
