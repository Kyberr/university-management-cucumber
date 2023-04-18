package ua.com.foxminded.university.stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ua.com.foxminded.university.WebDriverFactory;
import ua.com.foxminded.university.page.CoursePage;
import ua.com.foxminded.university.page.CoursesPage;
import ua.com.foxminded.university.page.HomePage;
import ua.com.foxminded.university.page.LoginPage;

public class CommonStepDefinitions {
    
    private WebDriver driver = WebDriverFactory.getInstance().getDriver();
    private LoginPage loginPage;
    private HomePage homePage;
    private CoursesPage coursesPage;
    private CoursePage coursePage;
    
    @When("the user clicks the SignIn button on the home page")
    public void the_user_clicks_the_SignIn_button_the_home_page() {
        homePage = new HomePage(driver);
        homePage.clickLoginButton();
    }
    
    @Then("the user sees the login page")
    public void the_user_sees_the_login_page() {
        String loginPageUrl = driver.getCurrentUrl();
        assertEquals(LoginPage.LOGIN_PAGE_URL, loginPageUrl);
    }
    
    @Given("a user sees the courses button on the home page")
    public void a_user_sees_the_courses_button_on_the_home_page() {
        homePage = new HomePage(driver);
        assertTrue(homePage.isCoursesButtonPresent());
    }
    
    @When("the user clicks the courses button")
    public void the_user_clicks_the_courses_button() {
        homePage = new HomePage(driver);
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
    
    @Then("the created course is present on the courses list page")
    public void the_created_course_is_present_on_the_courses_list_page() {
        assertTrue(coursesPage.isCoursePresent(CoursesPage.COURSE_NAME));
    }
    
    @Given("a user sees the courses list page")
    public void a_user_sees_the_courses_list_page() {
        driver.get(CoursesPage.COURSES_PAGE_URL);
        coursesPage = new CoursesPage(driver);
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
    
    @When("the user clicks a course name link")
    public void the_user_clicks_a_course_name_link() {
        coursesPage.findCouseLink(CoursesPage.COURSE_NAME)
                   .click();
    }
    
    @Then("the user goes to a course page")
    public void the_user_goes_to_a_course_page() {
        assertTrue(driver.getCurrentUrl().matches(CoursePage.COURSE_PAGE_URL_REGEX));
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
    
    @When("the user clicks the SignIn button on the login page")
    public void the_user_clicks_the_SignIn_button_on_the_login_page() {
        loginPage = new LoginPage(driver);
        loginPage.findSignInButton().click();
    }
    
    @Then("the user goes to the home page")
    public void the_user_goes_to_the_home_page() {
        assertEquals(HomePage.HOME_PAGE_URL, driver.getCurrentUrl());
    }
}
