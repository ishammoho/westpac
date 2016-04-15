package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import stepDefs.Hooks;

/**
 * Created by isham on 4/15/2016.
 * Page Objects for Currency Converter page
 */
public class CurrencyConverterPage {
    public WebDriver driver;

    private static WebElement element;

    public CurrencyConverterPage() {
        driver = Hooks.driver;
    }

    public static WebElement enterAmountField(WebDriver driver) {
        try {
            element = driver.findElement(By.xpath("//input[@id='Amount'][@type='text'][@name='Amount']"));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        return element;
    }

    public static WebElement convertButton(WebDriver driver) {
        try {
            element = driver.findElement(By.xpath("//p/input[@id='convert']"));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        return element;
    }

    public static WebElement amountMissingErrorMessage(WebDriver driver) {
        try {
            element = driver.findElement(By.xpath("//div[@id='errordiv']/ul/li"));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return element;
    }
}
