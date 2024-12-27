package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.*;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TaskPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    TaskPage taskPage;
    String sheeetName = "Tasks";

    public TaskPageTest()
    {
        super();
    }

    @BeforeMethod
    public void setUp()
    {
        initialization();
        testUtil = new TestUtil();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        testUtil.switchToFrame();
        taskPage = homePage.clickOnTaskLink();
    }

    @Test(priority = 1)
    public void verifyTasksLabelTest() {
        Assert.assertTrue(taskPage.verifyTasksLabel(), "Tasks label is missing on the page");
    }

    @Test(priority = 2)
    public void createNewDealTest() {
        homePage.clickOnNewTaskLink();
        taskPage.createNewTask("Follow Up","80","Open","High");
        // Additional verification steps can be added to confirm successful creation.
    }

    @DataProvider
    public Object[][] getCRMTestData() {
        return TestUtil.getTestData(sheeetName); // Retrieve data from Excel sheet
    }

    @Test(priority = 3, dataProvider = "getCRMTestData")
    public void createNewTaskTest(String title, String completionPercent, String taskStatus, String taskPriority) {
        taskPage.createNewTask(title, completionPercent, taskStatus, taskPriority);
    }


    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }

}
