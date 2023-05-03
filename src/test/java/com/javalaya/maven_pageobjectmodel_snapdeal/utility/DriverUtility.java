package com.javalaya.maven_pageobjectmodel_snapdeal.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class DriverUtility {

	public static int windowCount(WebDriver driver) {
		
		Set<String> allWindow = driver.getWindowHandles();
		return allWindow.size();
	}
	
	public static void switchtoWindow(WebDriver driver,int windowCount) {
		Set<String> allWindow = driver.getWindowHandles();
		List<String> windowList = new ArrayList<>(allWindow);
		driver.switchTo().window(windowList.get(windowCount-1));
	}
	
}
