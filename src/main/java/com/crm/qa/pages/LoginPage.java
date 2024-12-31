package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    //Page Factory : OR(Object Repository)
    @FindBy(name="username")
    WebElement username;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement loginBtn;

    @FindBy(xpath = "//a[contains(text() , 'Sign Up')]")
    WebElement signUpBtn;

    @FindBy(xpath = "//img[contains(@class,'img-responsive')]")
    WebElement crmLogo;

   //Initializing the Page Objects
    public LoginPage()
    {
        PageFactory.initElements(driver , this);
    }
   //Actions:
    @Step("getting login page title step...")
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }
    @Step("verifying the CRM Image Step..")
    public boolean validateCRMImage()
    {
        return crmLogo.isDisplayed();
    }
    @Step("login with userName : {0} and Password : {1} step...")
    public HomePage login(String un , String pwd)
    {
       username.sendKeys(un);
       password.sendKeys(pwd);
       loginBtn.click();
       return new HomePage();
    }

}
