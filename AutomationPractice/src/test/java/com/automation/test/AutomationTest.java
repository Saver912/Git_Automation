package com.automation.test;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.automation.pages.CotologPage;
import com.automation.pages.HomePage;
import com.automation.pages.HomePageWoman;
import com.library.Base;

public class AutomationTest extends Base{
	final static Logger logger = Logger.getLogger(AutomationTest.class);
	HomePage HP =new HomePage();
	HomePageWoman HPW =new HomePageWoman();
	CotologPage Cotolog =new CotologPage();
	
	@Test
	public void Test_Automation() {
		//HP.Search();
		HPW.go_to_AutomationWebsite();
		HPW.women();
		Cotolog.waitUntiPageLoadComplete();
		Cotolog.Catalog();
		
		
		
	}
}
