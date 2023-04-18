package ua.com.foxminded.university.stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ua.com.foxminded.university.WebDriverFactory;
import ua.com.foxminded.university.page.AdminPage;
import ua.com.foxminded.university.page.HomePage;
import ua.com.foxminded.university.page.LoginPage;

public class AdminFlowStepDefinitions {
    
    private LoginPage loginPage;
    private HomePage homePage;
    private AdminPage adminPage;
    private WebDriver driver = WebDriverFactory.getInstance().getDriver();
    
    @Then("the user clicks the authorize button of a user with id")
    public void the_user_clicks_the_authorize_button_of_a_user_with_id() {
        adminPage = new AdminPage(driver);
        adminPage.findAuthorizeButton(AdminPage.NOT_AUTHORIZED_USER_ID).click();
    }
    
    @Then("the user select authority in the authorize menu")
    public void the_user_select_authority_in_the_authorize_menu() {
        adminPage.selectAuthorityInAuthorizeMenu(AdminPage.STAFF_AUTHORITY, 
                                                 AdminPage.NOT_AUTHORIZED_USER_ID);
    }
    
    @Then("the user selects active status in the authorize menu")
    public void the_user_selects_active_status_in_the_authorize_menu() {
        adminPage.selectActiveStatusInAuthorizeMenu(AdminPage.ENABLED_STATUS, 
                                                    AdminPage.NOT_AUTHORIZED_USER_ID);
    }
    
    @Then("the user enters a password and confirm password")
    public void the_user_enters_a_password_and_confirm_password() {
        adminPage.enterPassword(AdminPage.NOT_AUTHORIZED_USER_ID, LoginPage.PASSWORD);
    }
    

    @Then("the user click the athorize button in the authorize menu") 
    public void the_user_click_the_athorize_button_in_the_authorize_menu() {
        adminPage.findAuthorizeButtonOfAuthorizedMenu(AdminPage.NOT_AUTHORIZED_USER_ID)
                 .click();;
    }
    
    @Then("the user sees updated data of the user on the admin panel")
    public void the_user_sees_updated_data_of_the_user_on_the_admin_panel() {
        assertTrue(adminPage.isAuthorizedUserPresent(AdminPage.NOT_AUTHORIZED_USER_ID, 
                AdminPage.STAFF_AUTHORITY_REPRESENTATION));
    }
    
    @Given("the user sees the admin panel button on the home page")
    public void the_user_sees_the_admin_panel_button_on_the_home_page() {
        homePage = new HomePage(driver);
        assertTrue(homePage.isAdminPanelPresent());;
    }
    
    @When("the user clicks the admin panel button on the home page")
    public void the_user_clicks_the_admin_panel_button_on_the_home_page() {
        homePage.clickAdminPanelButton();
    }
    
    @Then("the user sees the admin panel page")
    public void the_user_sees_the_admin_panel_page() {
        assertEquals(AdminPage.ADMIN_PAGE_URL, driver.getCurrentUrl());
    }
    
    @Then("the user clicks the Edit button of a user that has an email")
    public void the_user_clicks_the_Edit_button_of_a_user_that_has_an_email() {
        adminPage = new AdminPage(driver);
        WebElement editButton = adminPage.findEditButton(AdminPage.EMAIL, AdminPage.USER_ID);
        editButton.click();
    }
    
    @Then("the user selects admin authority")
    public void the_user_selects_admin_authority() {
        adminPage.selectAuthority(AdminPage.ADMIN_AUTHORITY, AdminPage.USER_ID);
    }
    
    @Then("the user selects staff authority")
    public void the_user_selects_staff_authority() {
        adminPage.selectAuthority(AdminPage.STAFF_AUTHORITY, AdminPage.USER_ID);
    }
    
    @Then("the user clicks the SaveChanges button")
    public void the_user_clicks_the_SaveChanges_button() {
        WebElement saveChangesButton = adminPage.findSaveChangesButton(AdminPage.USER_ID);
        saveChangesButton.click();
    }
    
    @Then("the user sees the admin authority of user in the list")
    public void the_user_sees_the_admin_authority_of_user_in_the_list() {
        assertTrue(adminPage.isUpdatedUserAuthorityPresent(AdminPage.EMAIL, 
                AdminPage.ADMIN_AUTHORITY_REPRESENTATION));
    }
    
    @Then("the user sees the staff authority of user in the list")
    public void the_user_sees_the_staff_authority_of_user_in_the_list() {
        assertTrue(adminPage.isUpdatedUserAuthorityPresent(AdminPage.EMAIL, 
                AdminPage.STAFF_AUTHORITY_REPRESENTATION));
    }
    
    @Given("a user enters admin credentials on the login page")
    public void a_user_enters_admin_credentials_on_the_login_page() {
        driver.get(LoginPage.LOGIN_PAGE_URL);
        loginPage = new LoginPage(driver);
        loginPage.enterCredentials(LoginPage.ADMIN_LOGIN, LoginPage.PASSWORD);
    }
}
