package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import stepDefs.Hooks;

/**
 * Created by isham on 4/15/2016.
 */
public class HomePage {

    public WebDriver driver;

    private static WebElement element;

    public HomePage() {
        driver = Hooks.driver;
    }

    public static WebElement fxTravelMigrantLink(WebDriver driver){
        element = driver.findElement(By.id("ubermenu-section-link-fx-travel-and-migrant-ps"));
        return element;
    }

    public static WebElement currencyConverterButton(WebDriver driver){
        element = driver.findElement(By.xpath("//a[@id='ubermenu-item-cta-currency-converter-ps']"));
        return element;
    }
}
