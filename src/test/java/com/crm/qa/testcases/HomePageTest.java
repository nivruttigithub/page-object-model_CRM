package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
     LoginPage loginPage;
     HomePage homePage;
     TestUtil testUtil;
     ContactsPage contactsPage;
     DealsPage dealsPage;
    public HomePageTest()
    {
        super();
    }
    @BeforeMethod
    public void setUp()
    {
        initialization();
        testUtil = new TestUtil();
        contactsPage = new ContactsPage();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void verifyHomePageTitleTest()
    {
        String homePageTitle = homePage.verifyHomePageTitle();
        Assert.assertEquals(homePageTitle,"CRMPRO","Home Page Title Not Matched");
    }
    @Test(priority = 2)
    public void verifyUserNameTest()
    {
        testUtil.switchToFrame();
        Assert.assertTrue(homePage.verifyCorrectUserName());
    }
    @Test(priority = 3)
    public void verifyContactsLinkTest()
    {
        testUtil.switchToFrame();
       contactsPage = homePage.clickOnContactcLink();
    }

    @Test(priority = 4)
    public void verifyDealsLinkTest()
    {
        testUtil.switchToFrame();
        dealsPage = homePage.clickOnDealsLink();
    }

    @AfterMethod
    public void tearDowm()
    {
        driver.quit();
    }
}
