package com.automation.example.stepdefs;

import com.automation.example.pages.FiddlePage;
import com.automation.example.pages.GettingStartedPage;
import com.automation.example.pages.ModalPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;



public class TestSteps {

    public static final String N_UNIT = "nUnit";
    public static final String HTTPS_DOTNETFIDDLE_NET = "https://dotnetfiddle.net/";
    public static final String[] MY_LIST_TEST_1 = {"a", "b", "c", "d", "e"};
    public static final String[] MY_LIST_TEST_2 = {"f", "g", "h", "i", "j", "k"};
    public static final String[] MY_LIST_TEST_3 = {"l", "m", "n", "o", "p"};
    public static final String[] MY_LIST_TEST_4 = {"q", "r", "s", "t", "u"};
    public static final String[] MY_LIST_TEST_5 = {"v", "w", "x", "y", "z"};

    public WebDriver driver;
    public FiddlePage fiddlePage;
    private String firstNameChar;


    @Before(order = 2)
    public void initWebDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

    }

    @Before(order = 3)
    public void initFiddlePage() {
        fiddlePage = new FiddlePage(driver);
        fiddlePage.navigateToRegisterPage();
    }

    @After()
    public void disposeWebDriver() {
        driver.quit();
    }



    @When("^the user selects run$")
    public void the_user_selects_run() {
        fiddlePage.clickButton(FiddlePage.BY_RUNBUTTON);

    }

    @Then("^then \"([^\"]*)\" is displayed in the output console$")
    public void then_is_displayed_in_the_output_console(String arg1) throws Exception {
        WebElement consoleOutput = driver.findElement(fiddlePage.BY_CONSOLEOUTPUT);
        String string = consoleOutput.getText();
        Assert.assertEquals(arg1, string);

    }
    @Given("^the user enters the \"([^\"]*)\"$")
    public void the_user_enters_the(String arg1) {
        fiddlePage.clearTextBoxAndSetValue(FiddlePage.BY_NAMEFIELD,arg1);
        firstNameChar=arg1.substring(0, 1);
    }

    @Then("^then the appropriate actions and validations \\(\"([^\"]*)\"$")
    public void then_the_appropriate_actions_and_validations(String arg1) throws InterruptedException {

        if(Arrays.stream(MY_LIST_TEST_1).anyMatch(firstNameChar::equalsIgnoreCase)){
            fiddlePage.clearTextBoxAndSetValue(fiddlePage.BY_NUGETPACKAGES, N_UNIT);
            fiddlePage.isElementDisplayed(fiddlePage.BY_DROPDOWNPACKAGE);
            fiddlePage.clickButton(fiddlePage.BY_NUNITITEM);
            fiddlePage.isElementDisplayed(fiddlePage.BY_SECONDDROPDOWN);
            fiddlePage.clickButton(fiddlePage.BY_NUNITVERSION);
            fiddlePage.isElementDisplayed(fiddlePage.BY_ADDEDPACKAGE);
            Assert.assertTrue(driver.findElement(fiddlePage.BY_ADDEDPACKAGE).getText().equalsIgnoreCase(N_UNIT));

        }
        else if (Arrays.stream(MY_LIST_TEST_2).anyMatch(firstNameChar::equalsIgnoreCase)){

           fiddlePage.clickButton(FiddlePage.BY_SHAREBUTTON);
           fiddlePage.WaitForAjax();
           Assert.assertTrue(fiddlePage.extractValue(FiddlePage.BY_SHARELINK).startsWith(HTTPS_DOTNETFIDDLE_NET));

         }
        else if (Arrays.stream(MY_LIST_TEST_3).anyMatch(firstNameChar::equalsIgnoreCase)){
            fiddlePage.isElementDisplayed(fiddlePage.BY_OPTIONSBAR);
            fiddlePage.isElementDisplayed(fiddlePage.BY_OPTIONSBARCHEVRON);
            fiddlePage.clickButton(fiddlePage.BY_OPTIONSBARCHEVRON);
            Assert.assertFalse(fiddlePage.isElementDisplayed(fiddlePage.BY_OPTIONSBARCHEVRON));


        }
        else if (Arrays.stream(MY_LIST_TEST_4).anyMatch(firstNameChar::equalsIgnoreCase)){
            fiddlePage.clickButton(FiddlePage.BY_SAVEBTN);
            ModalPage modalPage = new ModalPage(driver);
            modalPage.waitForModalVisible();
            Assert.assertTrue(modalPage.isElementDisplayed(modalPage.BY_LOGINMODAL));


        }
        else if (Arrays.stream(MY_LIST_TEST_5).anyMatch(firstNameChar::equalsIgnoreCase)){
            fiddlePage.clickButton(FiddlePage.BY_GETTINGSTARTED);
            GettingStartedPage gettingStartedPage = new GettingStartedPage(driver);
            Assert.assertTrue(gettingStartedPage.isElementDisplayed(gettingStartedPage.BY_BACKBTN));
        }
        else{
            Assert.fail("The Name Does Not start with an Alpha Character");
        }

    }

}
