# cucumber-jvm-java-test
This is an example BDD test automation Project for Java using the Cucumber-JVM framework.
It contains validation for https://dotnetfiddle.net/

### Purpose
This project was developed by Babir Munir 
to demonstrate how to use Cucumber-JVM as a BDD test framework.      

### Version
This project uses Cucumber-JVM 2.0, apache-maven-3.6.3 and Java 8.
If using IntelliJ IDEA, please make sure to update to the latest version of the
[Cucumber for Java plugin](https://plugins.jetbrains.com/plugin/7212-cucumber-for-java).
Delete any old Run Configurations if updating, as well.

### Web Driver Setup
This project uses Selenium WebDriver to interact with the Chrome web browser.


The source code may easily be changed to work with any other web browser.
Just remember to install the required web drivers.

### Running Tests
This project uses [Maven](https://maven.apache.org/).
To run tests, simply run "mvn test" from Command Line.
Can also be run from IDE by selecting IHSMarkit.feature and clicking play button

## Automation Framework
Framework: Comprise of an Abstract class which instantiates a Common driver to be used across Page Objects class.

Pages: Comprise of all page object models e.g. FiddlePage, GettingStartedPage and ModalPage

Runners: Contains a Cucumber Runner which glues Step Defs with Feature files and also configures the Output results.

Stepdefs: It comprises of methods that marry up with features and the classes in the other packages.



resources: Comprises of cucumber feature file
