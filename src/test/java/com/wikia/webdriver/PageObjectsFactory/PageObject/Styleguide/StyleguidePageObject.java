package com.wikia.webdriver.PageObjectsFactory.PageObject.Styleguide;

import com.wikia.webdriver.Common.ContentPatterns.URLsContent;
import com.wikia.webdriver.Common.Core.Global;
import com.wikia.webdriver.Common.Logging.PageObjectLogging;
import com.wikia.webdriver.PageObjectsFactory.PageObject.BasePageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class StyleguidePageObject extends BasePageObject {

	public StyleguidePageObject(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * @desc Opens Wikia Styleguide home page
	 */
	public void openStyleguidePage() {
		getUrl(Global.DOMAIN + URLsContent.specialStyleguide);
		PageObjectLogging.log("openStyleguidePage", "Styleguide page opened", true);
	}

}
