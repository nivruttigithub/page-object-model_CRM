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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DealsPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;
    DealsPage dealsPage;
    String sheeetName = "Deals";

    public DealsPageTest()
    {
        super();
    }

    @BeforeMethod
    public void setUp()
    {
        initialization();
        testUtil = new TestUtil();
        dealsPage = new DealsPage();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        testUtil.switchToFrame();
        dealsPage = homePage.clickOnDealsLink();
    }

    @Test(priority = 1)
    public void verifyDealsPageLabel()
    {
        Assert.assertTrue(dealsPage.verifyDealsLabel(),"Deals Label is Missing On The Page");
    }

    @Test(priority = 2)
    public void createNewDealTest() {
        homePage.clickOnNewDealLink();
        dealsPage.createNewDeal("Enterprise Software Purchase", "Tech Solutions Inc.", "25000", "75", "15");
        // Additional verification steps can be added to confirm successful creation.
    }

    @DataProvider
    public Object[][] getCRMTestData()
    {
        Object data[][] = TestUtil.getTestData(sheeetName);
        return data;
    }
    @Test(priority = 3,dataProvider = "getCRMTestData")
    public void validateCreateNewDealsTest(String title, String companyName, String dealAmount, String dealProbability, String dealCommission)
    {
        homePage.clickOnNewDealLink();
//    contactsPage.createNewContact("Mr.","Nivrutti","Wagh","QualityKiosk", "SDET");
        dealsPage.createNewDeal(title,companyName,dealAmount,dealProbability,dealCommission);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
