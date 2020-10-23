package com.automation.example.pages;

import com.automation.example.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ModalPage extends AbstractPage {

    public static final int TIMEOUT_SECONDS = 10;

    public ModalPage(WebDriver driver) {
        super(driver);
    }

    public static final By BY_LOGINMODAL = By.cssSelector(".modal-body");
    public static final By BY_MODALLOGINBTN = By.xpath("//button[contains(text(),'Log in')]");


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
    public boolean waitForModalVisible() {
        boolean displayed = false;
        try {
            if (driverWait(TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(BY_MODALLOGINBTN)).isDisplayed()){
                displayed = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return displayed;

    }
}

