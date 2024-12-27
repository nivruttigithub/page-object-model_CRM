package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase {
LoginPage loginPage;
HomePage homePage;
TestUtil testUtil;
ContactsPage contactsPage;

String sheeetName = "Contacts";
public ContactsPageTest()
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
    testUtil.switchToFrame();
    contactsPage = homePage.clickOnContactcLink();
}

@Test(priority = 1)
public void verifyContactsPageLabelTest()
{
    Assert.assertTrue(contactsPage.verifyContactsLabel(),"Contacts Label is Missing On The Page");
}
@Test(priority = 2)
public void selectSingleContactsTest()
{
    contactsPage.selectContactsByName("Tom Peter");
}
@Test(priority = 3)
public void selectMultipleContactsTest()
{
    contactsPage.selectContactsByName("Tom Peter");
    contactsPage.selectContactsByName("Tom fsf");
}

@DataProvider
public Object[][] getCRMTestData()
{
Object data[][] = TestUtil.getTestData(sheeetName);
return data;
}
@Test(priority = 4,dataProvider = "getCRMTestData")
public void validateCreateNewContact(String title,String firstName,String lastName,String company , String position)
{
    homePage.clickOnNewContactLink();
//    contactsPage.createNewContact("Mr.","Nivrutti","Wagh","QualityKiosk", "SDET");
    contactsPage.createNewContact(title,firstName,lastName,company,position);
}
@AfterMethod
    public void tearDown()
{
    driver.quit();
}
}
