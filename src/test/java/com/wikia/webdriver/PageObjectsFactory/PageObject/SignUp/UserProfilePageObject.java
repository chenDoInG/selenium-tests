package com.wikia.webdriver.PageObjectsFactory.PageObject.SignUp;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wikia.webdriver.Common.Core.Assertion;
import com.wikia.webdriver.Common.Core.MailFunctions;
import com.wikia.webdriver.Common.Logging.PageObjectLogging;
import com.wikia.webdriver.PageObjectsFactory.PageObject.WikiBasePageObject;
import com.wikia.webdriver.PageObjectsFactory.PageObject.Special.SpecialCreatePagePageObject;
import com.wikia.webdriver.PageObjectsFactory.PageObject.WikiPage.Blog.BlogPageObject;

public class UserProfilePageObject extends WikiBasePageObject {

	@FindBy(css="header#WikiaHeader a.ajaxLogin")
	private WebElement logInLink;
	@FindBy(css="li[data-id='blog'] a")
	private WebElement blogTab;
	@FindBy(css="a[data-id='createblogpost']")
	private WebElement createBlogPostButton;
	@FindBy(css=".WikiaBlogListingPost h1>a")
	private List<WebElement> blogPostList;

	public UserProfilePageObject(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * @author Karol Kujawiak
	 */
	public void verifyWelcomeEmail(String userName, String mailUserName, String mailPassword)
	{
		PageObjectLogging.log("verifyWelcomeEmail ", "start of email verification", true);
		String[] mailContent = MailFunctions.getWelcomeMailContent(MailFunctions.getFirstMailContent(mailUserName, mailPassword));
		Assertion.assertEquals("Edit your profile.", mailContent[4]);
		Assertion.assertEquals("Learn the basics.", mailContent[10]);
		Assertion.assertEquals("Get a quick tutorial on the basics of Wikia: how to edit a page, your user =profile, change your preferences, and more.", mailContent[12]);
		Assertion.assertEquals("Check it out (http://community.wikia.com/wiki/Help:Wikia_Basics)", mailContent[14]);
		Assertion.assertEquals("Explore more wikis.", mailContent[16]);
		Assertion.assertEquals("There are thousands of wikis on Wikia, find more wikis that interest you by= heading to one of our hubs: Video Games (http://www.wikia.com/Video_Games)=, Entertainment (http://www.wikia.com/Entertainment), or Lifestyle (http://=www.wikia.com/Lifestyle).", mailContent[18]);
		Assertion.assertEquals("Go to http://www.wikia.com", mailContent[20]);
		Assertion.assertEquals("Want more information? Find advice, answers, and the Wikia community at Com=munity Central (http://www.community.wikia.com). Happy editing!", mailContent[22]);
		Assertion.assertEquals("The Wikia Team", mailContent[24]);
		PageObjectLogging.log("verifyWelcomeEmail ", "end of email verification", true);
	}

	/**
	 * @author Michal Nowierski
	 */
	public void clickOnBlogTab() {
		waitForElementByElement(blogTab);
		waitForElementClickableByElement(blogTab);
		blogTab.click();
		PageObjectLogging.log("clickOnBlogTab", "Click on blog tab", true);
	}

	public BlogPageObject openBlogPage(int blogNumber) {
		blogPostList.get(blogNumber).click();
		PageObjectLogging.log("openBlogPage",
				"blog post " + blogPostList.get(0).getText() + " opened",
				true);
		return new BlogPageObject(driver);
	}

	public BlogPageObject openFirstPost() {
		openBlogPage(0);
		return new BlogPageObject(driver);
	}

	/**
	 * @author Michal Nowierski
	 * @return
	 */
	public SpecialCreatePagePageObject clickOnCreateBlogPost() {
		waitForElementByElement(createBlogPostButton);
		waitForElementClickableByElement(createBlogPostButton);
		scrollAndClick(createBlogPostButton);
		PageObjectLogging.log("clickOnCreateBlogPost", "Click on create blog post button", true, driver);
		return new SpecialCreatePagePageObject(driver);
	}
}
