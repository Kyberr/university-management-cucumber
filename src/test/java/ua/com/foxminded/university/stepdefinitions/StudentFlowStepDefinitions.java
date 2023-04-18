package ua.com.foxminded.university.stepdefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import ua.com.foxminded.university.WebDriverFactory;
import ua.com.foxminded.university.page.LoginPage;

public class StudentFlowStepDefinitions {
    
    private WebDriver driver = WebDriverFactory.getInstance().getDriver();
    private LoginPage loginPage;
    
    @Given("a user entered student credentials on the login page")
    public void a_user_entered_student_credentials_on_the_login_page() {
        driver.get(LoginPage.LOGIN_PAGE_URL);
        loginPage = new LoginPage(driver);
        loginPage.enterCredentials(LoginPage.STUDENT_LOGIN, LoginPage.PASSWORD);
    }
}
