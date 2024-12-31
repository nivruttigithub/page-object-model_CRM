package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
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
    @Test(priority=1 , description = "verifying the login page title test")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description :Verify login page title test on Login Page")
    @Story("Story Name : To Check login Page Title")
    public void loginPageTitleTest()
    {
        log.info("LoginPageTest Method is Running...");
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title,"Free CRM software for customer relationship management, sales, and support.");
    }

    @Test(priority = 2,description = "verifying CRM logo Image test ")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description :Verify CRM logo Image test on Login Page")
    @Story("Story Name : To Check CRM logo Image")
    public void crmLogoImageTest()
    {
        boolean flag = loginPage.validateCRMImage();
        Assert.assertTrue(flag);
    }
    @Test(priority = 3)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Case Description :Verify Login Page into the application with correct credintials")
    @Story("Story Name : To Check login Functionality")
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
