package ua.com.foxminded.university.stepdefinitions;


import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import ua.com.foxminded.university.WebDriverFactory;
import ua.com.foxminded.university.page.HomePage;

public class NotAuthorizedStepDefinitions {
    
    private  WebDriver driver = WebDriverFactory.getInstance().getDriver();
    
    @Given("a not authorized user has connection to the home page")
    public void a_user_has_connection_to_the_home_page() {
        driver.get(HomePage.HOME_PAGE_URL);
    }
}
