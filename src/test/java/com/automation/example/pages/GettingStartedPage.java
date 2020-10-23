package com.automation.example.pages;

import com.automation.example.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GettingStartedPage extends AbstractPage {

    public static final int TIMEOUT_SECONDS = 10;

    public GettingStartedPage(WebDriver driver) {

        super(driver);
    }

    public static final By BY_BACKBTN = By.xpath("//body/div[1]/div[2]/div[2]/div[1]/a[1]");


    public boolean isElementDisplayed(By locator) {
        boolean displayed = false;
        try {
            if (driverWait(TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(locator)).isDisplayed()) {
                displayed = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return displayed;
    }


}

