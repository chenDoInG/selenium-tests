/**
 *
 */
package com.wikia.webdriver.TestCases.SearchTests;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.wikia.webdriver.Common.Core.URLBuilder.UrlBuilder;
import com.wikia.webdriver.Common.DataProvider.CrossWikiSearchProvider;
import com.wikia.webdriver.Common.Templates.NewTestTemplate;
import com.wikia.webdriver.PageObjectsFactory.PageObject.WikiBasePageObject;
import com.wikia.webdriver.PageObjectsFactory.PageObject.Search.IntraWikiSearch.IntraWikiSearchPageObject;

/**
 * @author Karol 'kkarolk' Kujawiak
 *
 */
public class CrossWikiSearchCommunityTests extends NewTestTemplate{

	String testedWiki;
	String query;
	String extactMatchTitle;

	@Factory(
			dataProviderClass=CrossWikiSearchProvider.class,
			dataProvider="getExactMatchQueriesCommunity"
		)
		public CrossWikiSearchCommunityTests(String wikiName, String query, String exactMatchTitle) {
			super();
			UrlBuilder urlBuilder = new UrlBuilder(config.getEnv());
			testedWiki = urlBuilder.getUrlForWiki(wikiName);
			this.query = query;
			this.extactMatchTitle = exactMatchTitle;
		}

	@Test(groups = {"CrossWikiSearchTestsCommunity_001", "Search"})
	public void crossWikiSearch_001_exactMatch() {
		WikiBasePageObject base = new WikiBasePageObject(driver);
		IntraWikiSearchPageObject intraWikiSearch = base.openSpecialSearchPage(testedWiki);
	}


}
