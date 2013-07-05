package com.wikia.webdriver.TestCases.StyleguideTests;

import com.wikia.webdriver.Common.Templates.TestTemplate;
import com.wikia.webdriver.PageObjectsFactory.PageObject.Styleguide.ComponentsPageObject;
import org.testng.annotations.Test;

public class ComponentsTests extends TestTemplate {
	@Test(groups = {"components_001", "componentsStyleguide", "Styleguide"})
	public void checkComponentsListExists() {
		ComponentsPageObject components = new ComponentsPageObject(driver);
		components.openComponentsPage();
		components.verifyComponentsListPresent();
	}
}
