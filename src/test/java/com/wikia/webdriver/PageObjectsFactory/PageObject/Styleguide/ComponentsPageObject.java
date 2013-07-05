package com.wikia.webdriver.PageObjectsFactory.PageObject.Styleguide;

import com.wikia.webdriver.Common.ContentPatterns.URLsContent;
import com.wikia.webdriver.Common.Core.Global;
import com.wikia.webdriver.Common.Logging.PageObjectLogging;
import com.wikia.webdriver.PageObjectsFactory.PageObject.BasePageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComponentsPageObject extends BasePageObject {
	@FindBy(css="ul.components > li")
	private WebElement componentsList;

	public ComponentsPageObject(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * @desc Opens Components page on Wikia Styleguide
	 */
	public void openComponentsPage() {
		getUrl(Global.DOMAIN + URLsContent.componentsStyleguide);
		PageObjectLogging.log("openComponentsStyleguidePage", "Styleguide Components page opened", true);
	}

	public void verifyComponentsListPresent() {
		waitForElementByElement(componentsList);
		PageObjectLogging.log("verifyComponentsListPresent", "components list is present", true);
	}
}
