package com.library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	private static WebDriver driver;

	public static WebDriver getDriver(String browser) {
		if (driver == null) {
			if (browser == null) {
				browser = ConfigurationReader.getProperty(browser);
				switch (browser) {
				case "chrome":
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;
				case "Firefax":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;

				}
			}

		}

		return driver;

	}

}
