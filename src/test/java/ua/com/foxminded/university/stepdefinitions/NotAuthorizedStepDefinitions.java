package ua.com.foxminded.university.stepdefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import lombok.RequiredArgsConstructor;
import ua.com.foxminded.university.config.PageUrlConfig;

@RequiredArgsConstructor
public class NotAuthorizedStepDefinitions {
    
    private final PageUrlConfig config;
    private final WebDriver driver;
    
    @Given("a not authorized user has connection to the home page")
    public void a_user_has_connection_to_the_home_page() {
        driver.get(config.getHomePageUrl());
    }
}
