package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TaskPage extends TestBase {
    @FindBy(xpath = "//td[contains(text(),'Task')]")
    WebElement tasksLabel;

    @FindBy(xpath = "//input[@id='title']")
    WebElement taskTitle;

    @FindBy(name = "status")
    WebElement status;

    @FindBy(name = "completion")
    WebElement completion;

    @FindBy(name = "priority")
    WebElement priority;

    @FindBy(xpath = "//input[@type='submit' and @value='Save']")
    WebElement saveBtn;

    public  TaskPage()
    {
        PageFactory.initElements(driver,this);
    }
    public boolean verifyTasksLabel()
    {
        return  tasksLabel.isDisplayed();
    }

    public void createNewTask(String title,  String completionPercent, String taskStatus, String taskPriority) {
        taskTitle.sendKeys(title);
        completion.sendKeys(completionPercent);
        Select statusDropdown = new Select(status);
        statusDropdown.selectByVisibleText(taskStatus);
        Select priorityDropdown = new Select(priority);
        priorityDropdown.selectByVisibleText(taskPriority);
        saveBtn.click();
    }

}
