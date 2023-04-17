package ua.com.foxminded.university;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ua.com.foxminded.university.pageobjects.AdminPage;
import ua.com.foxminded.university.pageobjects.CoursePage;
import ua.com.foxminded.university.pageobjects.CoursesPage;
import ua.com.foxminded.university.pageobjects.HomePage;
import ua.com.foxminded.university.pageobjects.LoginPage;

public class StepDefinitions {
    
    public static final int NOT_AUTHORIZED_USER_ID = 6;
    public static final int USER_ID = 5;
    public static final String EMAIL = "person";
    public static final String PASSWORD = "a";
    public static final String TEACHER_LOGIN = "teacher";
    public static final String STUDENT_LOGIN = "student";
    public static final String STAFF_LOGIN = "staff";
    public static final String ADMIN_LOGIN = "a";

    public static WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private AdminPage adminPage;
    private CoursesPage coursesPage;
    private CoursePage coursePage;
    
    @BeforeAll
    public static void setUp() {
        driver = WebDriverFactory.createWebDriver();
    }
    
    @After
    public void reset() {
        driver.manage().deleteAllCookies();
    }
    
    @AfterAll
    public static void cleanUp() {
        driver.close();
    }
    
    @When("the user clicks the delete course button")
    public void the_user_clicks_the_delete_course_button() {
        coursesPage.findDeleteCourseButton(CoursePage.NEW_COURSE_NAME)
                   .click();
        coursesPage.findConfirmDeletingButton(CoursePage.NEW_COURSE_NAME)
                   .click();
    }
    
    @Then("the course is not present on the courses list page")
    public void the_course_is_not_present_on_the_courses_list_page() {
        assertFalse(coursesPage.isCoursePresent(CoursePage.NEW_COURSE_NAME));
    }

    @Then("the user enters a new course name into the input field")
    public void the_user_enters_a_new_course_name_into_the_input_field() {
        coursePage = new CoursePage(driver);
        coursePage.findCourseNameUpdateField()
                  .sendKeys(CoursePage.NEW_COURSE_NAME);
    }
    
    @Then("the user enters new course description into the input field")
    public void the_user_enters_new_course_description_into_the_input_field() {
        coursePage.findCourseDescriptionUpdateField()
                  .sendKeys(CoursePage.NEW_COURSE_DESCRIPTION);
    }
    
    @Then("the user clicks the save changes button on the course page")
    public void the_user_clicks_the_save_changes_button_on_the_course_page() {
        coursePage.findSaveUpdatedChangesButton()
                  .click();
    }
    
    @Then("the user sees updated couse data on the course page")
    public void the_user_sees_updated_couse_data_on_the_course_page() {
        assertTrue(coursePage.isCourseDataPresent(CoursePage.NEW_COURSE_NAME, 
                                                  CoursePage.NEW_COURSE_DESCRIPTION));
    }
    
    @Given("a user sees the courses list page")
    public void a_user_sees_the_courses_list_page() {
        driver.get(CoursesPage.COURSES_PAGE_URL);
        coursesPage = new CoursesPage(driver);
    }
    
    @When("the user clicks a couse name link")
    public void the_user_clicks_a_couse_name_link() {
        coursesPage.findCouseLink(CoursesPage.COURSE_NAME)
                   .click();
    }
    
    @Then("the user goes to a course page")
    public void the_user_goes_to_a_course_page() {
        assertTrue(driver.getCurrentUrl().matches(CoursePage.COURSE_PAGE_URL_REGEX));
    }
    
    @Given("a user sees the courses button on the home page")
    public void a_user_sees_the_courses_button_on_the_home_page() {
        homePage = new HomePage(driver);
        assertTrue(homePage.isCoursesButtonPresent());
    }
    
    @When("the user clicks on the courses button")
    public void the_user_clicks_on_the_courses_button() {
        homePage.findCoursesButton().click();
    }
    
    @Then("the user goes to the courses list page")
    public void the_user_goes_to_the_courses_list_page() {
        assertEquals(CoursesPage.COURSES_PAGE_URL, driver.getCurrentUrl());
    }
    
    @Then("the user clicks the create button")
    public void the_user_clicks_the_create_button() {
        coursesPage = new CoursesPage(driver);
        coursesPage.findCreateButton().click();
    }
    
    @Then("the user enters a course name on the create course panel")
    public void the_user_enters_a_course_name_on_the_create_course_panel() {
        coursesPage.findCourseNameInputField()
                   .sendKeys(CoursesPage.COURSE_NAME);
    }
    
    @Then("the user enters a course desctiption on the create course panel")
    public void the_user_enters_a_course_desctiption_on_the_create_course_panel() {
        coursesPage.findCourseDescriptionInputField()
                   .sendKeys(CoursesPage.COURSE_DESCRIPTION);
    }
    
    @Then("the user clicks the save changes button on the create course panel")
    public void the_user_clicks_the_save_changes_button_on_the_create_course_panel() {
        coursesPage.findSaveChangesButtonOfCreatePanel().click();
    }
    
    @Then("the created course is present in the courses list page")
    public void the_created_course_is_present_in_the_courses_list_page() {
        assertTrue(coursesPage.isCoursePresent(CoursesPage.COURSE_NAME));
    }
    
    @Given("a not authorized user has connection to the home page")
    public void a_user_has_connection_to_the_home_page() {
        driver.manage().deleteAllCookies();
        driver.get(HomePage.HOME_PAGE_URL);
        homePage = new HomePage(driver);
    }
    
    @When("the user clicks on the SignIn button on the login page")
    public void the_user_clicks_on_the_sign_on_button_the_login_page() {
        homePage.clickLoginButton();
    }
    
    @Then("the user sees the login page")
    public void the_user_sees_the_login_page() {
        String loginPageUrl = driver.getCurrentUrl();
        assertEquals(LoginPage.LOGIN_PAGE_URL, loginPageUrl);
    }
    
    @Given("a user entered admin credentials on the login page")
    public void a_user_entered_admin_credentials_on_the_login_page() {
        driver.get(LoginPage.LOGIN_PAGE_URL);
        loginPage = new LoginPage(driver);
        loginPage.enterCredentials(ADMIN_LOGIN, PASSWORD);
    }

    @When("the user clicks on the SignIn button")
    public void the_user_clicks_on_the_sign_in_button() {
        loginPage.findSignInButton().click();
    }
    
    @Then("the user goes to the home page")
    public void the_user_goes_to_the_home_page() {
        assertEquals(HomePage.HOME_PAGE_URL, driver.getCurrentUrl());
    }
    
    @Given("the user sees the admin panel button on the home page")
    public void the_user_sees_the_admin_panel_button() {
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
    
    @Given("a user entered staff credentials on the login page")
    public void a_user_entered_staff_credentials_on_the_login_page() {
        driver.get(LoginPage.LOGIN_PAGE_URL);
        loginPage = new LoginPage(driver);
        loginPage.enterCredentials(STAFF_LOGIN, PASSWORD);
    }
    
    @Then("the home page does not have the admin panel button")
    public void the_home_page_does_not_have_the_admin_panel_button() {
        homePage = new HomePage(driver);
        assertFalse(homePage.isAdminPanelPresent());
    }
    
    @Given("a user entered teacher credentials on the login page")
    public void a_user_entered_teacher_credentials_on_the_login_page() {
        driver.get(LoginPage.LOGIN_PAGE_URL);
        loginPage = new LoginPage(driver);
        loginPage.enterCredentials(TEACHER_LOGIN, PASSWORD);
    }
    
    @Given("a user entered student credentials on the login page")
    public void a_user_entered_student_credentials_on_the_login_page() {
        driver.get(LoginPage.LOGIN_PAGE_URL);
        loginPage = new LoginPage(driver);
        loginPage.enterCredentials(STUDENT_LOGIN, PASSWORD);
    }
    
    @Then("the user clicks the Edit button of a user that has email")
    public void the_user_clicks_the_edit_button_of_user_that_has_email() {
        adminPage = new AdminPage(driver);
        WebElement editButton = adminPage.findEditButton(EMAIL, USER_ID);
        editButton.click();
    }
    
    @Then("the user selects admin authority")
    public void the_user_selects_admin_authority() {
        adminPage.selectAuthority(AdminPage.ADMIN_AUTHORITY, USER_ID);
    }
    
    @Then("the user clicks the SaveChanges button")
    public void the_user_clicks_the_SaveChanges_button() {
        WebElement saveChangesButton = adminPage.findSaveChangesButton(USER_ID);
        saveChangesButton.click();
    }
    
    @Then("the user sees the admin authority of user in the list")
    public void the_user_sees_the_admin_authority_of_user_in_the_list() {
        assertTrue(adminPage.isUpdatedUserAuthorityPresent(EMAIL, 
                AdminPage.ADMIN_AUTHORITY_REPRESENTATION));
    }
    
    @Then("the user selects staff authority")
    public void the_user_selects_staff_authority() {
        adminPage.selectAuthority(AdminPage.STAFF_AUTHORITY, USER_ID);
    }
    
    @Then("the user sees the staff authority of user in the list")
    public void the_user_sees_the_staff_authority_of_user_in_the_list() {
        assertTrue(adminPage.isUpdatedUserAuthorityPresent(EMAIL, 
                AdminPage.STAFF_AUTHORITY_REPRESENTATION));
    }
    
    @Then("the user clicks on the authorize button of a user with id")
    public void the_user_clicks_on_the_authorize_button_of_a_user_with_id() {
        adminPage = new AdminPage(driver);
        adminPage.findAuthorizeButton(NOT_AUTHORIZED_USER_ID).click();
    }
    
    @Then("the user select authority in the authorize menu")
    public void the_user_select_authority_in_the_authorize_menu() {
        adminPage.selectAuthorityInAuthorizeMenu(AdminPage.STAFF_AUTHORITY, 
                                                 NOT_AUTHORIZED_USER_ID);
    }
    @Then("the user select active status in the authorize menu")
    public void the_user_select_active_status_in_the_authorize_menu() {
        adminPage.selectActiveStatusInAuthorizeMenu(AdminPage.ENABLED_STATUS, 
                                                    NOT_AUTHORIZED_USER_ID);
    }
    
    @Then("the user enters a password and confirm password")
    public void the_user_enters_a_password_and_confirm_password() {
        adminPage.enterPassword(NOT_AUTHORIZED_USER_ID, PASSWORD);
    }
    
    @Then("the user click the athorize button on the authorize menu") 
    public void the_user_click_the_athorize_button_on_the_authorize_menu() {
        adminPage.findAuthorizeButtonOfAuthorizedMenu(NOT_AUTHORIZED_USER_ID)
                 .click();;
    }
  
    @Then("the user sees updated data of the user on the admin panel")
    public void the_user_sees_updated_data_of_the_user_on_the_admin_panel() {
        assertTrue(adminPage.isAuthorizedUserPresent(NOT_AUTHORIZED_USER_ID, 
                AdminPage.STAFF_AUTHORITY_REPRESENTATION));
    }
}
