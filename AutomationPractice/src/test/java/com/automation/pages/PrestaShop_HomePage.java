 package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrestaShop_HomePage {
	
	public PrestaShop_HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "search_query_top")
	public WebElement SearchBox;
	
	
	@FindBy(name = "submit_search")
	public WebElement SearchButton;
	
	@FindBy(css=".lighter")
	public WebElement SearchResult;
	
	@FindBy(css=".alert-warning")
	public WebElement errorMessage;
	
	@FindBy(css=".alert-warning")
	public WebElement emtyMessage;

}
