package ua.com.foxminded.university.stepdefinitions;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ua.com.foxminded.university.config.PageUrlConfig;
import ua.com.foxminded.university.page.LoginPage;

public class LoginPageStepDefinitions {
    
    private LoginPage loginPage;
    private PageUrlConfig config;
    
    public LoginPageStepDefinitions(PageUrlConfig config) {
        this.config = config;
        loginPage = new LoginPage();
    }
    
    @Given("a user enters teacher credentials on the login page")
    public void a_user_enters_teacher_credentials_on_the_login_page() {
        Selenide.open(config.getLoginPageUrl());
        loginPage.enterCredentials(LoginPage.TEACHER_LOGIN, LoginPage.PASSWORD);
    }
    
    @Given("a user entered student credentials on the login page")
    public void a_user_entered_student_credentials_on_the_login_page() {
        Selenide.open(config.getLoginPageUrl());
        loginPage.enterCredentials(LoginPage.STUDENT_LOGIN, LoginPage.PASSWORD);
    }
    
    @Then("the user goes to the login page")
    public void the_user_goes_to_the_login_page() {
        Selenide.webdriver().shouldHave(
                WebDriverConditions.url(config.getLoginPageUrl()));
    }
    
    @Given("a user enters admin credentials on the login page")
    public void a_user_enters_admin_credentials_on_the_login_page() {
        Selenide.open(config.getLoginPageUrl());
        loginPage.enterCredentials(LoginPage.ADMIN_LOGIN, LoginPage.PASSWORD);
    }
    
    @When("the user clicks the SignIn button on the login page")
    public void the_user_clicks_the_SignIn_button_on_the_login_page() {
        loginPage.findSignInButton().click();
    }
    
    @Given("a user enters staff credentials on the login page")
    public void a_user_enters_staff_credentials_on_the_login_page() {
        Selenide.open(config.getLoginPageUrl());
        loginPage.enterCredentials(LoginPage.STAFF_LOGIN, LoginPage.PASSWORD);
    }
}
