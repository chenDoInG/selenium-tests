package com.wikia.webdriver.TestCases.WamTests;

import java.util.List;

import org.testng.annotations.Test;

import com.wikia.webdriver.Common.Core.Assertion;
import com.wikia.webdriver.Common.Templates.TestTemplate;
import com.wikia.webdriver.PageObjectsFactory.PageObject.WAM.WamPageObject;

public class WamTests extends TestTemplate{
	
	
	/*
	 * checking page content before and after pagination
	 */
	@Test(groups = { "Wam001", "Wam" })
	public void wam_001(){
		WamPageObject wam = new WamPageObject(driver);
		wam.getWamPage();
		List<String> page1Urls = wam.getWikiUrlList();
		String page1Number = wam.getCurrentPageNumber();
		wam.clickNext();
		List<String> page2Urls = wam.getWikiUrlList();
		String page2Number = wam.getCurrentPageNumber();
		wam.compareUrls(page1Urls, page2Urls);
		Assertion.assertNotEquals(page1Number, page2Number);
	}

	/*
	 * select hub from vertical drop-down,
	 * check that all wikis are from selected hub 
	 */
	@Test(groups = { "Wam002", "Wam" })
	public void wam_002(){
		
	}
	
	/*
	 * select date one day before today
	 * check that wiki's list is different 
	 */
	@Test(groups = { "Wam003", "Wam" })
	public void wam_003(){
		
	}
	
	
}
