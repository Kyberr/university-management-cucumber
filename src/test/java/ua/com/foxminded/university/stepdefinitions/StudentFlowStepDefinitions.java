package ua.com.foxminded.university.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import ua.com.foxminded.university.config.PageUrlConfig;
import ua.com.foxminded.university.page.LoginPage;

public class StudentFlowStepDefinitions {
    
    private LoginPage loginPage;
    private PageUrlConfig config;
    private WebDriver driver;
    
    public StudentFlowStepDefinitions(WebDriver driver, PageUrlConfig config) {
        this.driver = driver;
        this.config = config;
        this.loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Given("a user entered student credentials on the login page")
    public void a_user_entered_student_credentials_on_the_login_page() {
        driver.get(config.getLoginPageUrl());
        loginPage.enterCredentials(LoginPage.STUDENT_LOGIN, LoginPage.PASSWORD);
    }
}
