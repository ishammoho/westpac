package stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pageobjects.CurrencyConverterPage;
import pageobjects.HomePage;

import java.util.concurrent.TimeUnit;

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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        HomePage.currencyConverterButton(driver).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("^I enter '(.*?)' to the Enter Amount field$")
    public void enterAmount(String amount) {
        CurrencyConverterPage.enterAmountField(driver).sendKeys(amount);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("^I click on the Convert button$")
    public void clickConvertButton() {

    }

    @Then("^I should be able to see the following error messages$")
    public void I_should_be_able_to_see_the_following_error_messages(String arg1) {
    }

}
