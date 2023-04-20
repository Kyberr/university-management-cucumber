package ua.com.foxminded.university.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Value;

import io.cucumber.java.en.Given;
import ua.com.foxminded.university.page.LoginPage;

public class StaffFlowStepDefinitions {
    
    @Value("${loginPageUrl}")
    private String loginPageUrl;
    
    private LoginPage loginPage;
    private WebDriver driver;
    
    public StaffFlowStepDefinitions(WebDriver driver) {
        this.driver = driver;
        this.loginPage = PageFactory.initElements(driver, LoginPage.class);
        
    }

    @Given("a user enters staff credentials on the login page")
    public void a_user_enters_staff_credentials_on_the_login_page() {
        driver.get(loginPageUrl);
        loginPage.enterCredentials(LoginPage.STAFF_LOGIN, LoginPage.PASSWORD);
        loginPage.findSignInButton();
    }
}
