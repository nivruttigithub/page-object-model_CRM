package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DealsPage extends TestBase {

    @FindBy(xpath = "//td[contains(text(),'Deals')]")
    WebElement dealsLabel;

    @FindBy(id = "title")
    WebElement dealTitle;

    @FindBy(name = "client_lookup")
    WebElement company;

    @FindBy(id = "amount")
    WebElement amount;

    @FindBy(id = "probability")
    WebElement probability;

    @FindBy(id = "commission")
    WebElement commission;

    @FindBy(xpath = "//input[@type='submit' and @value='Save']")
    WebElement saveBtn;

    public  DealsPage()
    {
        PageFactory.initElements(driver,this);
    }
    public boolean verifyDealsLabel()
    {
        return  dealsLabel.isDisplayed();
    }

    public void createNewDeal(String title, String companyName, String dealAmount, String dealProbability, String dealCommission) {
        driver.findElement(By.name("title")).sendKeys(title);
        company.sendKeys(companyName);
        amount.sendKeys(dealAmount);
        probability.sendKeys(dealProbability);
        commission.sendKeys(dealCommission);
        saveBtn.click();
    }

}
