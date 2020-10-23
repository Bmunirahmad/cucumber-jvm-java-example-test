package com.automation.example.pages;

import com.automation.example.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class FiddlePage extends AbstractPage {

    public static final int TIMEOUT_SECONDS = 10;



    public FiddlePage(WebDriver driver) {
        super(driver);
    }

    public static final String FIDDLE_URL = "https://dotnetfiddle.net/";

    public static final By BY_CONSOLEOUTPUT = By.cssSelector("#output");
    public static final By BY_RUNBUTTON = By.id("run-button");
    public static final By BY_NAMEFIELD = By.xpath("//body/div[1]/div[3]/div[1]/form[1]/div[2]/div[3]/div[1]/input[1]");
    public static final By BY_SHAREBUTTON = By.cssSelector("#Share");
    public static final By BY_SHARELINK = By.cssSelector("#ShareLink");
    public static final By BY_SAVEBTN = By.cssSelector("#save-button");
    public static final By BY_OPTIONSBAR = By.xpath("//body[1]/div[1]/div[3]/div[1]/form[1]/div[2]/div[2]");
    public static final By BY_OPTIONSBARCHEVRON = By.xpath("//body/div[1]/div[3]/div[1]/form[1]/div[2]/div[2]/div[1]/button[1]/span[1]");
    public static final By BY_MODALLOGINBTN = By.xpath("//button[contains(text(),'Log in')]");
    public static final By BY_GETTINGSTARTED = By.xpath("//body/div[1]/div[2]/div[2]/div[2]/div[5]/a[1]");
    public static final By BY_NUGETPACKAGES = By.xpath("//body/div[1]/div[3]/div[1]/form[1]/div[2]/div[2]/div[5]/div[1]/div[1]/input[1]");
    public static final By BY_DROPDOWNPACKAGE = By.cssSelector("#menu");
    public static final By BY_NUNITITEM = By.cssSelector("body:nth-child(2) ul.ui-menu.ui-widget.ui-widget-content.ui-corner-all:nth-child(22) li.ui-menu-item:nth-child(1) a.ui-corner-all > span.ui-menu-icon.ui-icon.ui-icon-carat-1-e");
    public static final By BY_SECONDDROPDOWN = By.cssSelector("body:nth-child(2) ul.ui-menu.ui-widget.ui-widget-content.ui-corner-all:nth-child(22) li.ui-menu-item:nth-child(1) > ul.ui-menu.ui-widget.ui-widget-content.ui-corner-all");
    public static final By BY_NUNITVERSION = By.xpath("//body/ul[@id='menu']/li[1]/ul[1]/li[1]/a[1]");
    public static final By BY_ADDEDPACKAGE = By.xpath("//div[contains(text(),'NUnit')]");

    public void navigateToFiddlePage() {
        getDriver().navigate().to(FIDDLE_URL);
    }

    public void clearTextBoxAndSetValue(By locator, String text) {
        WebElement textbox = driverWait(TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(locator));
        if (text instanceof String) {
            try {
                textbox.clear();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            text = "";
        }
        textbox.sendKeys(text);
    }

    public String extractValue(By locator) {
        WebElement inpElement = driverWait(TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(locator));
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        return String.valueOf(executor.executeScript("return arguments[0].value", inpElement));
    }

    public void clickButton(By locator){
        WebElement button = driverWait(TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(locator));
        button.click();
    }

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



    public void WaitForAjax() throws InterruptedException
    {
        while (true)
        {

            Boolean ajaxIsComplete = (Boolean) ((JavascriptExecutor)getDriver()).executeScript("return jQuery.active == 0");
            if (ajaxIsComplete){
                break;
            }
            Thread.sleep(100);
        }
    }

}

