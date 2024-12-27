package com.crm.qa.util;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.TestNGUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WebEventListener extends TestBase implements WebDriverListener {

    private static final Logger logger = Logger.getLogger(WebEventListener.class.getName());

    @Override
    public void beforeAnyCall(Object target, Method method, Object[] args) {
        WebDriverListener.super.beforeAnyCall(target, method, args);
    }

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        logger.info("Attempting to find element: " + locator);
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        logger.info("Element found: " + locator);
    }

    @Override
    public void beforeClick(WebElement element) {
        logger.info("Attempting to click on element: " + getElementDetails(element));
    }

    @Override
    public void afterClick(WebElement element) {
        logger.info("Clicked on element: " + getElementDetails(element));
    }


    // Utility method to get element details
    private String getElementDetails(WebElement element) {
        try {
            return element.toString();
        } catch (StaleElementReferenceException e) {
            return "Stale element reference - element is no longer valid.";
        }
    }

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        System.out.println("Error in method: " + method.getName() + " on target: " + target + " with exception: " + e.getCause());
        try {
            TestUtil.takeScreenshotAtEndOfTest();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        WebDriverListener.super.onError(target, method,args,e);
}

}