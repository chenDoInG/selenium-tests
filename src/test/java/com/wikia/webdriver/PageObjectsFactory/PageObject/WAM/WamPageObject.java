package com.wikia.webdriver.PageObjectsFactory.PageObject.WAM;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.wikia.webdriver.Common.ContentPatterns.URLsContent;
import com.wikia.webdriver.Common.Core.Assertion;
import com.wikia.webdriver.Common.Logging.PageObjectLogging;
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
	@FindBy(id="WamFilterDate")
	private WebElement wamFilterDate;
	@FindBy(css=".ui-datepicker-today a")
	private WebElement uiDatepickerToday;
	@FindBy(id="verticalId")
	private WebElement hubSelectMenu;
	@FindBys(@FindBy(css="#wam-index td:nth-child(5)"))
	private List<WebElement> wikiHubList;

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

	public void clickPreviousDate() {
		wamFilterDate.click();
		waitForElementByElement(uiDatepickerToday);

		String today = uiDatepickerToday.getText();
		PageObjectLogging.log("clickPreviousDate", "today is: " + today, true);

		Integer yesterdayInt = Integer.parseInt(today);
		yesterdayInt--;
		String yesterday = Integer.toString(yesterdayInt);
		PageObjectLogging.log("clickPreviousDate", "yesterday was: " + yesterday, true);

		WebElement yesterdayLink = driver.findElement(By.linkText(yesterday));
		yesterdayLink.click();
	}

	public void chooseVertical(String hubName) {
		Select dropDown = new Select(hubSelectMenu);
		dropDown.selectByVisibleText(hubName);
	}

	public List<String> getWikiHubList(){
		List<String> urlList = new ArrayList<String>();
		for (WebElement item:wikiHubList){
			urlList.add(item.getText());
		}
		return urlList;
	}

	public void compareHubs(List<String> hubs, String hubName){
		for (int i=0; i<hubs.size(); i++){
			Assertion.assertEquals(hubs.get(i), hubName);
		}
	}


}
