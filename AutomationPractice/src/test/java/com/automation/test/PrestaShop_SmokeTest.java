package com.automation.test;

import javax.naming.directory.SearchResult;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pages.PrestaShop_HomePage;
import com.library.Base1;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrestaShop_SmokeTest extends Base1{
	//PrestaShop_HomePage HomePage = new PrestaShop_HomePage();
	
	/**
	 * as a costumer, i should be able to go to PrestaShop home Page and type the item name
	 * Scenario  1: user should be able to type the item name and view it.
	 * 
	 * test stop1: go to http://automationpractice.com/index.php
	 * test step 2: type item name in Search box
	 * test step 3: click on Search 
	 * test step 4: verify that system opens next page which has the type item
	 * 
	 */
	
	@Test(enabled =false)
	public void verifySearchBox_positive() {
		PrestaShop_HomePage HomePage = new PrestaShop_HomePage(driver);
		driver.get("http://automationpractice.com/index.php");
		HomePage.SearchBox.sendKeys("dress");
		HomePage.SearchButton.click();
		Assert.assertTrue(HomePage.SearchResult.isDisplayed(),"dress");
		
	}
	/**
	 * same user story as about 
	 * Scenario 2 : when user types invalid item name and system should indicate invalid massage
	 *      test stop1: go to http://automationpractice.com/index.php
	 *      test step 2: type item name in Search box
	 *      test step 3: click on Search 
	 *      test step 4: verify that system indicates "No results were found for your search" 
	 */
	@Test(enabled=false)
	public void verifySearchBox_Negative() {
		PrestaShop_HomePage HomePage = new PrestaShop_HomePage(driver);
		driver.get("http://automationpractice.com/index.php");
		HomePage.SearchBox.sendKeys("xnveri");
		HomePage.SearchButton.click();
		//it is check whether there is error message or not
		Assert.assertTrue(HomePage.errorMessage.isDisplayed());
		//if ther is error message, is it same as Expected error message
		Assert.assertTrue(HomePage.errorMessage.getText().contains("No results were found for your search"));
	}
	@Test
	public void verifySearchBox_NegativeTest() {
		PrestaShop_HomePage HomePage = new PrestaShop_HomePage(driver);
		driver.get("http://automationpractice.com/index.php");
		HomePage.SearchBox.sendKeys("");
		HomePage.SearchButton.click();
		//it is check whether there is error message or not
		Assert.assertTrue(HomePage.emtyMessage.isDisplayed());
		//if ther is error message, is it same as Expected error message
		Assert.assertTrue(HomePage.emtyMessage.getText().contains("Please enter a search keyword"));
	}
	
		
		
	@Test(enabled = false)
	public void productInfo_Test() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.navigate().to("http://automationpractice.com/index.php");
		String title = driver.getTitle();
		Assert.assertEquals(title, "My Store");

		WebElement product = driver
				.findElement(By.xpath("//img[@class='replace-2x img-responsive' and @title='Blouse'])[1]\""));

		product.click();
		driver.close();
		driver.quit();
	}

	@Test(enabled = false)
	public void product_Info() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.navigate().to("http://automationpractice.com/index.php");
	

//		WebElement product =driver.findElement(By.xpath("(//img[@title='Blouse'])[1]"));
//		product.click();
//		

		WebElement proName1 = driver.findElement(By.partialLinkText("Blouse"));
		proName1.click();
		String proName12 = driver.findElement(By.partialLinkText("Blouse")).getText();
		WebElement proName2 = driver.findElement(By.partialLinkText("Blouse"));
		String proName11 = driver.findElement(By.partialLinkText("Blouse")).getText();

		Assert.assertEquals(proName12, proName11);

		WebElement proPrice1 = driver.findElement(By.id("our_price_display"));
		String proPrice = driver.findElement(By.id("our_price_display")).getText();

		WebElement proPrice2 = driver.findElement(By.xpath("//span[@id='our_price_display']"));
		String proPrice3 = driver.findElement(By.xpath("//span[@id='our_price_display']")).getText();

		Assert.assertEquals(proPrice, proPrice3);

		WebElement quantity = driver.findElement(By.xpath("//input[@id='quantity_wanted'and@value='1']"));

		WebElement sizeElm = driver.findElement(By.xpath("//select[@id='group_1']"));

		Select dropDown = new Select(sizeElm);
		dropDown.selectByVisibleText("S");
		Thread.sleep(2000);
		dropDown.selectByVisibleText("M");
		Thread.sleep(2000);
		dropDown.selectByVisibleText("L");

	}

	@Test(enabled=false)
	public void producitInfo_addTO_car() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.navigate().to("http://automationpractice.com/index.php");
		WebElement proName1 = driver.findElement(By.partialLinkText("Blouse"));
		proName1.click();
		WebElement proName2 = driver.findElement(By.partialLinkText("Blouse"));
		String proName12 = driver.findElement(By.partialLinkText("Blouse")).getText();
        System.out.println(proName12);
		Assert.assertEquals(proName12, proName2);

		WebElement proPrice1 = driver.findElement(By.id("our_price_display"));
		String proPrice = driver.findElement(By.id("our_price_display")).getText();

		WebElement proPrice2 = driver.findElement(By.xpath("//span[@id='our_price_display']"));
		String proPrice3 = driver.findElement(By.xpath("//span[@id='our_price_display']")).getText();

		Assert.assertEquals(proPrice, proPrice3);

		WebElement quantity = driver.findElement(By.xpath("//input[@id='quantity_wanted'and@value='1']"));

		WebElement sizeElm = driver.findElement(By.xpath("//select[@id='group_1']"));

		Select dropDown = new Select(sizeElm);
		dropDown.selectByVisibleText("M");
		Thread.sleep(2000);
		
		WebElement color=driver.findElement(By.id("color_11"));
		color.click();
		
		WebElement addToCar =driver.findElement(By.id("add_to_cart"));
		addToCar.click();
		
		WebElement messed=driver.findElement(By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']//h2"));
	
		Thread.sleep(2000);
		String messed1 = messed.getText();
		
		Assert.assertEquals(messed1,"Product successfully added to your shopping cart");
		
		WebElement quantityElm= driver.findElement(By.id("layer_cart_product_quantity"));
		Thread.sleep(2000);
		String Elm=quantityElm.getText();
		
		Assert.assertEquals(Elm,"1");
		
		WebElement size=driver.findElement(By.id("layer_cart_product_attributes"));
		String sizeE=size.getText();
		String[] sizeSplit=sizeE.split(", ");
		Assert.assertTrue( sizeE.contains(sizeSplit[1]));
		
		WebElement nameOnCart= driver.findElement(By.id("layer_cart_product_title"));
		String carProductNameE =nameOnCart.getText();
		Assert.assertEquals(carProductNameE, proName12);
		WebElement priceOnCart=driver.findElement(By.id("layer_cart_product_attributes"));
		String expectedPrice = priceOnCart.getText();
		
		Assert.assertEquals(expectedPrice , proPrice3);
		
		
		
		

	}

}
