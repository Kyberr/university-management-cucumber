package ua.com.foxminded.university.stepdefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import ua.com.foxminded.university.WebDriverFactory;

public class Hooks {
    
    public static WebDriver driver = WebDriverFactory.getInstance().getDriver();
    
    @Before
    public void setUp() {
        driver.manage().deleteAllCookies();
    }
    
    @AfterAll
    public static void cleanUp() {
        driver.close();
    }
}
