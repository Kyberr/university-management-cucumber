package ua.com.foxminded.university.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;

import io.cucumber.java.en.Given;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NotAuthorizedStepDefinitions {
    
    @Value("${homePageUrl}")
    private String homePageUrl;
    
    private final WebDriver driver;
    
    @Given("a not authorized user has connection to the home page")
    public void a_user_has_connection_to_the_home_page() {
        driver.get(homePageUrl);
    }
}
