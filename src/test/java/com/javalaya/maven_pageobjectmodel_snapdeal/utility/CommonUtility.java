package com.javalaya.maven_pageobjectmodel_snapdeal.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;

public class CommonUtility {

	public static HashMap<String, String> allData = new HashMap<>();

	public static void readPropertiesfiles(String fileName) {
		String fn = fileName.endsWith(".properties") ? fileName : fileName + ".properties";
		try (FileInputStream fis = new FileInputStream("snapdeal_testdata/" + fn)) {
			Properties p = new Properties();
			p.load(fis);

			for (Object t : p.keySet()) {
				allData.put(t.toString(), p.getProperty(t.toString()));
			}
		} catch (Exception e) {
		}
	}

	public static void readPropertiesfiles(final File folder) {
		for (final File fileEntry : folder.listFiles()) {
			readPropertiesfiles(fileEntry.getName());
		}
	}

	
}
