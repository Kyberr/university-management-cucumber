package ua.com.foxminded.university.stepdefinitions;

import org.openqa.selenium.WebElement;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverConditions;

import io.cucumber.java.en.Then;
import ua.com.foxminded.university.config.PageUrlConfig;
import ua.com.foxminded.university.page.AdminPage;
import ua.com.foxminded.university.page.LoginPage;

public class AdminPageStepDefinitions {
    
    private PageUrlConfig config;
    private AdminPage adminPage;
    
    public AdminPageStepDefinitions(PageUrlConfig config) {
        this.config = config;
        adminPage = new AdminPage();
    }
    
    @Then("the user clicks the authorize button of a user with id")
    public void the_user_clicks_the_authorize_button_of_a_user_with_id() {
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
        adminPage.findAuthorizedUser(AdminPage.NOT_AUTHORIZED_USER_ID, 
                AdminPage.STAFF_AUTHORITY_REPRESENTATION).should(Condition.exist);
    }
    
    @Then("the user selects staff authority")
    public void the_user_selects_staff_authority() {
        adminPage.selectAuthority(AdminPage.STAFF_AUTHORITY, AdminPage.USER_ID);
    }
    
    @Then("the user sees the staff authority of user in the list")
    public void the_user_sees_the_staff_authority_of_user_in_the_list() {
        adminPage.findUpdatedUserAuthority(AdminPage.EMAIL, 
                AdminPage.STAFF_AUTHORITY_REPRESENTATION).should(Condition.exist);
    }
    
    @Then("the user sees the admin authority of user in the list")
    public void the_user_sees_the_admin_authority_of_user_in_the_list() {
        adminPage.findUpdatedUserAuthority(AdminPage.EMAIL, 
                AdminPage.ADMIN_AUTHORITY_REPRESENTATION).should(Condition.exist);
    }
    
    @Then("the user clicks the SaveChanges button")
    public void the_user_clicks_the_SaveChanges_button() {
        adminPage.findSaveChangesButton(AdminPage.USER_ID).click();;
    }
    
    @Then("the user selects admin authority")
    public void the_user_selects_admin_authority() {
        adminPage.selectAuthority(AdminPage.ADMIN_AUTHORITY, AdminPage.USER_ID);
    }
    
    @Then("the user clicks the Edit button of a user that has an email")
    public void the_user_clicks_the_Edit_button_of_a_user_that_has_an_email() {
        WebElement editButton = adminPage.findEditButton(AdminPage.EMAIL, AdminPage.USER_ID);
        editButton.click();
    }
    
    @Then("the user sees the admin panel page")
    public void the_user_sees_the_admin_panel_page() {
        Selenide.webdriver().shouldHave(WebDriverConditions.url(config.getAdminPageUrl()));
    }
}
