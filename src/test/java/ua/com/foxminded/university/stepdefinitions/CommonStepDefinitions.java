package ua.com.foxminded.university.stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ua.com.foxminded.university.config.PageUrlConfig;
import ua.com.foxminded.university.page.CoursePage;
import ua.com.foxminded.university.page.CoursesPage;
import ua.com.foxminded.university.page.GroupPage;
import ua.com.foxminded.university.page.HomePage;
import ua.com.foxminded.university.page.LoginPage;

public class CommonStepDefinitions {
    
    public static final String ERROR_PAGE_TITLE = "Error page";
    
    private PageUrlConfig config;
    private LoginPage loginPage;
    private HomePage homePage;
    private CoursesPage coursesPage;
    private CoursePage coursePage;
    private GroupPage groupPage;
    private WebDriver driver;

    public CommonStepDefinitions(WebDriver driver, PageUrlConfig config) {
        this.driver = driver;
        this.config = config;
        this.loginPage = PageFactory.initElements(driver, LoginPage.class);
        this.homePage = PageFactory.initElements(driver, HomePage.class);
        this.coursesPage = PageFactory.initElements(driver, CoursesPage.class);
        this.coursePage = PageFactory.initElements(driver, CoursePage.class);
        this.groupPage = PageFactory.initElements(driver, GroupPage.class);
    }
    
    @Then("the user clicks the confirm button of created group")
    public void the_user_clicks_the_confirm_button_of_created_group() {
        groupPage.findConfirmDeletingButtonByOrder(GroupPage.CREATED_GROUP_ORDER).click();
    }
    
    @When("the user clicks the delete button of created group")
    public void the_user_clicks_the_delete_button_of_created_group() {
        groupPage.findDeleteButtonByGroupName(GroupPage.UPDATED_GROUP_NAME).click();;
    }

    @Then("the deleted group is not present")
    public void the_deleted_group_is_not_present() {
        assertTrue(groupPage.groupNameIsNotPresent(GroupPage.UPDATED_GROUP_NAME));
    }
    
    @When("the user clicks on text link of the created group")
    public void the_user_clicks_on_text_link_of_the_created_group() {
        groupPage.findLinkText(GroupPage.CREATED_GROUP_NAME).click();
    }
    
    @Then("the user inputs a group name to the group name field")
    public void the_user_inputs_a_group_name_to_the_group_name_field() {
        groupPage.updateGroupName(GroupPage.UPDATED_GROUP_NAME);
    }
    
    @Then("the user clicks on the update group button")
    public void the_user_clicks_on_the_update_group_button() {
        groupPage.findNameUpdateButton().click();;
    }

    @Then("the user clicks the confirm button")
    public void the_user_clicks_the_confirm_button() {
        groupPage.findConfirmButton().click();
    }
    
    @Then("the user sees the updated group name in the group page")
    public void the_user_sees_the_updated_group_name_in_the_group_page() {
        assertTrue(groupPage.isTextPresent(GroupPage.UPDATED_GROUP_NAME));
    }
    
    @Then("the user cliscks on the course name link")
    public void the_user_cliscks_on_the_course_name_link() {
        groupPage.findLinkText(GroupPage.EXISTENCE_GROUP_NAME).click();
    }
    
    @Then("the user sees a course page")
    public void the_user_sees_a_course_page() {
        assertTrue(driver.getCurrentUrl().matches(config.getGroupPageUrlRegex()));
    }
    
    @Given("a user sees the group list page")
    public void a_user_sees_the_group_list_page() {
        driver.get(config.getGroupsPageUrl());
    }
    
    @When("the user clicks the create group button")
    public void the_user_clicks_the_create_group_button() {
        groupPage.findCreateButton().click();
    }
    
    @Then("the user imputs a group name")
    public void the_user_imputs_a_group_name() {
        groupPage.enterGroupName(GroupPage.CREATED_GROUP_NAME);
    }
    
    @Then("press the save changes button")
    public void press_the_save_changes_button() {
        groupPage.findSaveChangesButton().click();
    }
    
    @Then("the user sees the created course on the group list page")
    public void the_user_sees_the_created_course_on_the_group_list_page() {
        assertTrue(groupPage.isGroupNamePresent(GroupPage.CREATED_GROUP_NAME));
    }
    
    @When("the user clicks the created course name link")
    public void the_user_clicks_the_created_course_name_link() {
        coursesPage.findCouseLink(CoursePage.COURSE_NAME).click();
    }
    
    @When("the user clicks the delete course button of existence course")
    public void the_user_clicks_the_delete_course_button_of_existence_course() {
        coursesPage.findCouseLink(CoursesPage.EXISTENCE_COURSE_NAME).click();
    }

    @Then("the user request is denied")
    public void the_user_request_is_denied() {
        assertEquals(ERROR_PAGE_TITLE, driver.getTitle());
    }
    
    @When("the user clicks the SignIn button on the home page")
    public void the_user_clicks_the_SignIn_button_the_home_page() {
        homePage.findSignInButton().click();
    }
    
    @Then("the user sees the login page")
    public void the_user_sees_the_login_page() {
        assertEquals(config.getLoginPageUrl(), driver.getCurrentUrl());
    }
    
    @Given("a user sees the courses button on the home page")
    public void a_user_sees_the_courses_button_on_the_home_page() {
        assertTrue(homePage.isCoursesButtonPresent());
    }
    
    @When("the user clicks the courses button")
    public void the_user_clicks_the_courses_button() {
        homePage.findCoursesButton().click();
    }
    
    @Then("the user goes to the courses list page")
    public void the_user_goes_to_the_courses_list_page() {
        assertEquals(config.getCoursesPageUrl(), driver.getCurrentUrl());
    }
    
    @Then("the user clicks the create button")
    public void the_user_clicks_the_create_button() {
        coursesPage.findCreateButton().click();
    }
    
    @Then("the user enters a course name on the create course panel")
    public void the_user_enters_a_course_name_on_the_create_course_panel() {
        coursesPage.findCourseNameInputField()
                   .sendKeys(CoursePage.COURSE_NAME);
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
        assertTrue(coursesPage.isCoursePresent(CoursePage.COURSE_NAME));
    }
    
    @Given("a user sees the courses list page")
    public void a_user_sees_the_courses_list_page() {
        driver.get(config.getCoursesPageUrl());
    }
    
    @When("the user clicks the delete course button of updated course")
    public void the_user_clicks_the_delete_course_button_of_updated_course() {
        coursesPage.findDeleteCourseButton(CoursePage.UPDATED_COURSE_NAME)
                   .click();
        coursesPage.findConfirmDeletingButton(CoursePage.UPDATED_COURSE_NAME)
                   .click();
    }
    
    @When("the user clicks the delete course button of a existence course")
    public void the_user_clicks_the_delete_course_button_of_a_existence_course() {
        coursesPage.findDeleteCourseButton(CoursesPage.EXISTENCE_COURSE_NAME)
                   .click();
        coursesPage.findConfirmDeletingButton(CoursesPage.EXISTENCE_COURSE_NAME)
                   .click();
    }

    
    @Then("the created course is not present on the courses list page")
    public void the_created_course_is_not_present_on_the_courses_list_page() {
        assertFalse(coursesPage.isCoursePresent(CoursePage.UPDATED_COURSE_NAME));
    }
    
    @When("the user clicks an existence course name link")
    public void the_user_clicks_an_existence_course_name_link() {
        coursesPage.findCouseLink(CoursesPage.EXISTENCE_COURSE_NAME)
                   .click();
    }
    
    @Then("the user goes to a course page")
    public void the_user_goes_to_a_course_page() {
        assertEquals(CoursePage.COURSE_TITLE, driver.getTitle());
    }
    
    @Then("the user enters a new course name into the input field")
    public void the_user_enters_a_new_course_name_into_the_input_field() {
        coursePage.findCourseNameUpdateField()
                  .sendKeys(CoursePage.UPDATED_COURSE_NAME);
    }
    
    @Then("the user enters new course description into the input field")
    public void the_user_enters_new_course_description_into_the_input_field() {
        coursePage.findCourseDescriptionUpdateField()
                  .sendKeys(CoursePage.UPDATED_COURSE_DESCRIPTION);
    }
    
    @Then("the user clicks the save changes button on the course page")
    public void the_user_clicks_the_save_changes_button_on_the_course_page() {
        coursePage.findSaveUpdatedChangesButton()
                  .click();
    }
    
    @Then("the user sees updated couse data on the course page")
    public void the_user_sees_updated_couse_data_on_the_course_page() {
        assertTrue(coursePage.isCourseDataPresent(CoursePage.UPDATED_COURSE_NAME, 
                                                  CoursePage.UPDATED_COURSE_DESCRIPTION));
    }
    
    @When("the user clicks the SignIn button on the login page")
    public void the_user_clicks_the_SignIn_button_on_the_login_page() {
        loginPage.findSignInButton().click();
    }
    
    @Then("the user goes to the home page")
    public void the_user_goes_to_the_home_page() {
        assertEquals(config.getHomePageUrl(), driver.getCurrentUrl());
    }
}