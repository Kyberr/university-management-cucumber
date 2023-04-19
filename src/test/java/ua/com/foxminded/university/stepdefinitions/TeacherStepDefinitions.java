package ua.com.foxminded.university.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Value;

import io.cucumber.java.en.Given;
import ua.com.foxminded.university.page.LoginPage;

public class TeacherStepDefinitions {
    
    @Value("${loginPageUrl}")
    private String loginPageUrl;
    
    private LoginPage loginPage;
    private WebDriver driver;

    public TeacherStepDefinitions(WebDriver driver) {
        this.driver = driver;
        this.loginPage = PageFactory.initElements(driver, LoginPage.class);
    }
    
    @Given("a user enters teacher credentials on the login page")
    public void a_user_enters_teacher_credentials_on_the_login_page() {
        driver.get(loginPageUrl);
        loginPage.enterCredentials(LoginPage.TEACHER_LOGIN, LoginPage.PASSWORD);
    }
}
