package com.wikia.webdriver.PageObjects.PageObject.WikiPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wikia.webdriver.Common.Core.Global;
import com.wikia.webdriver.Common.Logging.PageObjectLogging;

public class BlogPageObject extends WikiArticlePageObject{

	@FindBy(css="div.author-details")
	private WebElement usernameField;
	
	By image = By.cssSelector("img");
	By firstSpan = By.cssSelector("span:nth-child(2) a");
	By secondSpan = By.cssSelector("span:nth-child(3)");
	By thirdSpan = By.cssSelector("span:nth-child(4) a");
	
	public BlogPageObject(WebDriver driver, String Domain, String wikiArticle) {
		super(driver, Domain, wikiArticle);
		PageFactory.initElements(driver, this);
	}

	public void verifyUsernameFieldPresent(String userName) {
		waitForElementByElement(usernameField);
		waitForElementByElement(usernameField.findElement(image));
		waitForValueToBePresentInElementsAttributeByElement(usernameField.findElement(image), "alt", userName);
		waitForTextToBePresentInElementByElement(usernameField.findElement(firstSpan), userName);
		
		waitForElementByElement(usernameField.findElement(secondSpan));
		waitForTextToBePresentInElementByElement(usernameField.findElement(thirdSpan), "User blog:"+userName);
		PageObjectLogging.log("verifyUsernameFieldPresent ", "verify that Username Field and all its element are presesnt", true, driver);			
	}
	
	public SpecialCreateBlogPageObject editBlog(){
		getUrl(driver.getCurrentUrl()+"?action=edit");
		PageObjectLogging.log("editBlog", "blog is in edit mode now", true, driver);
		return new SpecialCreateBlogPageObject(driver, this.Domain, this.articlename);
	}
	
	public void deleteBlogPost(String postName){
		getUrl(driver.getCurrentUrl() + "?action=delete");
		clickArticleDeleteConfirmationButton(postName);
		waitForElementByXPath("//div[@class='msg' and contains(text(), 'has been deleted.')]");
		PageObjectLogging.log("deleteArticle", "article has been deleted",
				true, driver);
	}

}