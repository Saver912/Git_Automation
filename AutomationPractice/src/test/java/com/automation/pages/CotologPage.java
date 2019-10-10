package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.library.Base;

public class CotologPage extends Base {
	public CotologPage waitUntiPageLoadComplete() {
		WebElement compareElm = mylibrary.fluentWait(By.xpath("(//form[@class='compare-form'])[1]"));
		Assert.assertNotNull(compareElm.getText(), "buyfu");
		return this;
	}
	public CotologPage Catalog() {
		mylibrary.handleCheckBoxRadioBtn(By.id("layered_id_attribute_group_2"), true);
		mylibrary.customWait(2);
		mylibrary.handleCheckBoxRadioBtn(By.id("layered_id_attribute_group_3"), true);
		mylibrary.handleCheckBoxRadioBtn(By.id("layered_id_feature_13"), true);
		mylibrary.customWait(2);
		mylibrary.clickButton(By.cssSelector(".right-block [rel] span"));
		
		/*Actions action = new Actions(driver);
		action.dragAndDrop(driver.findElement(By.className(".available-now")), (driver.findElement(By.cssSelector("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span")))).click();
		
		*/
		return this;
	}
}
