package ua.com.foxminded.university.stepdefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.Before;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Hooks {
    
    public final WebDriver driver;

    @Before
    public void setUp() {
        driver.manage().deleteAllCookies();
    }
}
