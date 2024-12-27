package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    public LoginPageTest()
    {
        setUp();
    }
    @BeforeMethod
    public void setUp()
    {
        initialization();
        loginPage = new LoginPage();
    }
    @Test(priority=1)
    public void loginPageTitleTest()
    {
        log.info("LoginPageTest Method is Running...");
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title,"Free CRM software for customer relationship management, sales, and support.");
    }
    @Test(priority = 2)
    public void crmLogoImageTest()
    {
        boolean flag = loginPage.validateCRMImage();
        Assert.assertTrue(flag);
    }
    @Test(priority = 3)
    public void loginTest()
    {
        homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    }
    @AfterTest
    public void tearDown()
    {
        if(driver != null)
        driver.quit();
    }

}
