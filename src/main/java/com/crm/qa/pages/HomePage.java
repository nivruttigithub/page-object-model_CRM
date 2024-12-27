package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(xpath = "//td[contains(text(),'User: Gagan Khanna')]")
    WebElement userNameLabel;
    @FindBy(xpath = "//a[contains(text(),'Contacts')]")
    WebElement contactsLink;
    @FindBy(xpath = "//a[contains(text(),'New Contact')]")
    WebElement newcontactLink;
    @FindBy(xpath = "//a[contains(text(),'Deals')]")
    WebElement dealsLink;
    @FindBy(xpath = "//a[contains(text(),'New Deal')]")
    WebElement newDealLink;
    @FindBy(xpath = "//a[contains(text(),'Tasks')]")
    WebElement tasksLink;
    @FindBy(xpath = "//a[contains(text(),'New Task')]")
    WebElement newTaskLink;
// Initializing the Page Objects
    public HomePage()
    {
        PageFactory.initElements(driver,this);
    }
    public boolean verifyCorrectUserName()
    {
        return userNameLabel.isDisplayed();
    }
    public String verifyHomePageTitle()
    {
        return driver.getTitle();
    }
    public ContactsPage clickOnContactcLink()
    {
        contactsLink.click();
        return new ContactsPage();
    }
    public DealsPage clickOnDealsLink()
    {
        dealsLink.click();
        return new DealsPage();
    }
    public TaskPage clickOnTaskLink()
    {
        tasksLink.click();
        return new TaskPage();
    }
    public void clickOnNewContactLink()
    {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector(\"a[title='Contacts']\").dispatchEvent(new Event('mouseover'))");

        // WebElement newContactLink = driver.findElement(By.xpath("//a[contains(text(),'New Contact')]"));
        js.executeScript("arguments[0].click();", newcontactLink);

//        Actions action = new Actions(driver);
//        action.moveToElement(contactsLink).build().perform();
//        newcontactLink.click();

    }

        public void clickOnNewDealLink() {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            // Perform mouseover on Deals Link
            js.executeScript("arguments[0].dispatchEvent(new Event('mouseover'))", dealsLink);
            // Click on New Deal Link
            js.executeScript("arguments[0].click();", newDealLink);
        }

    public void clickOnNewTaskLink() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Perform mouseover on Deals Link
        js.executeScript("arguments[0].dispatchEvent(new Event('mouseover'))", tasksLink);
        // Click on New Deal Link
        js.executeScript("arguments[0].click();", newTaskLink);
    }

}
