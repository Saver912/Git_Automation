package com.automation.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.library.Base;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage extends Base {

	public HomePage Search() {
		driver.get("http://automationpractice.com/index.php");
		String actualPageTitle = driver.getTitle();
		System.out.println("Website title is: " + actualPageTitle);
		assertEquals(actualPageTitle, "My Store");

		return this;
	}

	/**
	 * as a costumer, i should be able to go to PrestaShop home Page and type the
	 * item name Scenario 1: user should be able to type the item name and view it.
	 * 
	 * test stop1: go to http://automationpractice.com/index.php test step 2: type
	 * item name in Search box test step 3: click on Search test step 4: verify that
	 * system opens next page which has the type item
	 * 
	 */

	public HomePage verifySearchBox_positive() {
		// PrestaShop_HomePage HomePage = new PrestaShop_HomePage(driver);
		driver.get("http://automationpractice.com/index.php");
		mylibrary.enterTextField(By.id("search_query_top"), "dress");
		mylibrary.clickButton(By.name("submit_search"));
		WebElement searchResult = driver.findElement(By.className("heading-counter"));
		Assert.assertTrue(searchResult.isDisplayed(), "7 results have been found");
		return this;

	}

	/**
	 * same user story as about Scenario 2 : when user types invalid item name and
	 * system should indicate invalid massage test stop1: go to
	 * http://automationpractice.com/index.php test step 2: type item name in Search
	 * box test step 3: click on Search test step 4: verify that system indicates
	 * "No results were found for your search"
	 */

	public HomePage verifySearchBox_Negative() {
		driver.get("http://automationpractice.com/index.php");
		mylibrary.enterTextField(By.id("search_query_top"), "xnveri");
		mylibrary.clickButton(By.name("submit_search"));
		WebElement errorMessage = driver.findElement(By.cssSelector("#center_column > p"));
		// it is check whether there is error message or not
		Assert.assertTrue(errorMessage.isDisplayed());
		// if there is error message, is it same as Expected error message
		Assert.assertTrue(errorMessage.getText().contains("No results were found for your search"));
		return this;
	}

	public HomePage EmptySearchBox_NegativeTest() {
		driver.get("http://automationpractice.com/index.php");
		mylibrary.enterTextField(By.id("search_query_top"), "");
		mylibrary.clickButton(By.name("submit_search"));
		WebElement emptyMessage = driver.findElement(By.className("alert alert-warning"));
		// it is check whether there is error message or not
		Assert.assertTrue(emptyMessage.isDisplayed());
		// if there is error message, is it same as Expected error message
		Assert.assertTrue(emptyMessage.getText().contains("Please enter a search keyword"));
		return this;
	}

	public HomePage Select_Woman() {

		mylibrary.enterTextField(By.name("search_query"), "woman");
		mylibrary.selectDropDown(By.partialLinkText("T-shirts > Faded Short Sleeve T-shirts"), 3);
		mylibrary.clickButton(By.id("search"));

		return this;
	}

}
