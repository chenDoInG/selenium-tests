package com.wikia.webdriver.PageObjectsFactory.PageObject.WAM;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.wikia.webdriver.Common.ContentPatterns.URLsContent;
import com.wikia.webdriver.Common.Core.Assertion;
import com.wikia.webdriver.PageObjectsFactory.PageObject.BasePageObject;

public class WamPageObject extends BasePageObject{

	public WamPageObject(WebDriver driver) {
		super(driver);
	}

	@FindBys(@FindBy(css="tr a"))
	private List<WebElement> wikiUrlList;
	@FindBy(className="paginator-next")
	private WebElement nextButton;
	@FindBy(css=".paginator-page.active")
	private WebElement currentPage;
	@FindBy(className="wam-tabs")
	private WebElement wamTabs;
	
	public List<String> getWikiUrlList(){
		List<String> urlList = new ArrayList<String>();
		for (WebElement item:wikiUrlList){
			urlList.add(item.getText());
		}
		return urlList;
	}
	
	public void compareUrls(List<String> urlList1, List<String> urlList2){
		for (int i=0; i<urlList1.size(); i++){
			Assertion.assertNotEquals(urlList1.get(i), urlList2.get(i));
		}
	}
	
	public String getCurrentPageNumber(){
		waitForElementByElement(currentPage);
		return currentPage.getText();
	}
	
	public void getWamPage(){
		getUrl(URLsContent.wamUrl);
		waitForElementByElement(wamTabs);
	}
	
	public void clickNext(){
		waitForElementByElement(nextButton);
		nextButton.click();
	}
}
