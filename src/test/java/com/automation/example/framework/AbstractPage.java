package com.automation.example.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    private WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait driverWait(long timeoutSeconds) {
        return new WebDriverWait(driver, timeoutSeconds);
    }

}
