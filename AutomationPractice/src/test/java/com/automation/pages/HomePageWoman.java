package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.library.Base;

import jxl.common.Logger;


public class HomePageWoman extends Base{
	final static Logger logger=Logger.getLogger(HomePageWoman.class);
	
	public HomePageWoman go_to_AutomationWebsite() {
		driver.get("http://automationpractice.com/index.php");
		String actualPageTitle =driver.getTitle();
		System.out.println("Website title is: "+actualPageTitle);
		Assert.assertEquals(actualPageTitle, "My Store");
		
		return this;
	} 
	
	
	public  HomePageWoman women() {
		WebElement womanElem =driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(1) > a"));
		Actions action =new Actions(driver);
		action.moveToElement(womanElem).build().perform();
		WebElement casualElem= driver.findElement(By.partialLinkText("Casual Dresses"));
		action.moveToElement(casualElem).build().perform();
		casualElem.click();
		
		
		return this;
	}
	

}
