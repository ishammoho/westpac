package stepDefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;

/**
 * Created by isham on 4/15/2016.
 */
public class Hooks {
    public static WebDriver driver;

    @Before
    public void openBrowser() throws MalformedURLException {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @After
    public void quit() {
        driver.quit();
    }
}
