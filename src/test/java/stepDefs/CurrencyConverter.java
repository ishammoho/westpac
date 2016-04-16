package stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.CurrencyConverterPage;
import pageobjects.HomePage;

/**
 * Created by isham on 4/15/2016.
 * Step definition class for currency converter
 */
public class CurrencyConverter {

    public WebDriver driver;

    public CurrencyConverter() {
        driver = Hooks.driver;
    }

    @Given("^I am on currency converter page$")
    public void gotoCurrencyConverterPage() {
        driver.get("http://www.westpac.co.nz/");

        Actions action = new Actions(driver);
        action.moveToElement(HomePage.fxTravelMigrantLink(driver)).build().perform();
        WebElement element = (new WebDriverWait(driver,10)).until(ExpectedConditions.elementToBeClickable(HomePage.currencyConverterButton(driver)));
        element.click();
    }

    @When("^I enter '(.*?)' to the Enter Amount field$")
    public void enterAmount(String amount) {
        driver.switchTo().frame(driver.findElement(By.id("westpac-iframe")));
        CurrencyConverterPage.enterAmountField(driver).sendKeys(amount);
        driver.switchTo().defaultContent();
    }

    @When("^I click on the Convert button$")
    public void clickConvertButton() {
        driver.switchTo().frame(driver.findElement(By.id("westpac-iframe")));
        CurrencyConverterPage.convertButton(driver).click();
        driver.switchTo().defaultContent();
    }

    @Then("^I should be able to see the following error messages$")
    public void verifyCorrectErrorMessageIsDisplayed(String errorMessage) {
        driver.switchTo().frame(driver.findElement(By.id("westpac-iframe")));
        Assert.assertEquals(CurrencyConverterPage.amountMissingErrorMessage(driver).getText().toLowerCase().trim(),
                errorMessage.toLowerCase());
        driver.switchTo().defaultContent();
    }

    @When("^I select (.*?) from Convert From Drop Down$")
    public void selectConvertFromDropDownValue(String convertFromValue) {
        driver.switchTo().frame(driver.findElement(By.id("westpac-iframe")));
        Select select = new Select(CurrencyConverterPage.convertFromDropDown(driver));
        select.selectByVisibleText(convertFromValue);
        driver.switchTo().defaultContent();
    }

    @When("^I select (.*?) from the Convert To Drop DOwn$")
    public void selectConvertToDropDownValue(String convertToValues) {
        driver.switchTo().frame(driver.findElement(By.id("westpac-iframe")));
        Select select = new Select(CurrencyConverterPage.convertToDropDown(driver));
        select.selectByVisibleText(convertToValues);
        driver.switchTo().defaultContent();
    }

    //Code only verifies whether the conversion results are displayed. Doesn't verify whether
    //correct results are displayed
    @Then("^I should be able to see results for the currency conversion in currency converter page$")
    public void verifyCurrencyConversionResultsDisplayed() {
        driver.switchTo().frame(driver.findElement(By.id("westpac-iframe")));
        Assert.assertEquals(CurrencyConverterPage.conversionResults(driver).isDisplayed(), true);
        driver.switchTo().defaultContent();
    }
}
