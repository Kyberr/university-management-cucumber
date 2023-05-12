package ua.com.foxminded.university.stepdefinitions;

import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ua.com.foxminded.university.config.PageUrlConfig;
import ua.com.foxminded.university.page.CoursePage;
import ua.com.foxminded.university.page.CoursesPage;

public class CoursesPageStepDefinitions {
    
    private CoursesPage coursesPage;
    private PageUrlConfig config;
    
    public CoursesPageStepDefinitions(PageUrlConfig config) {
        this.config = config;
        this.coursesPage = new CoursesPage();
    }
    
    @When("the user clicks the delete course button of a present course")
    public void the_user_clicks_the_delete_course_button_of_a_present_course() {
        coursesPage.findDeleteCourseButton(CoursesPage.PRESENT_COURSE_NAME)
                   .click();
        coursesPage.findConfirmDeletingButton(CoursesPage.PRESENT_COURSE_NAME)
                   .click();
    }
    
    @When("the user clicks the delete course button of existence course")
    public void the_user_clicks_the_delete_course_button_of_existence_course() {
        coursesPage.findCouseLink(CoursesPage.PRESENT_COURSE_NAME).click();
    }
    
    @When("the user clicks the delete course button of a course")
    public void the_user_clicks_the_delete_course_button_of_a_course() {
        coursesPage.findDeleteCourseButton(CoursePage.COURSE_NAME)
                   .click();
        coursesPage.findConfirmDeletingButton(CoursePage.COURSE_NAME)
                   .click();
    }
    
    @Then("the user goes to the courses list page")
    public void the_user_goes_to_the_courses_list_page() {
        Selenide.webdriver().shouldHave(
                WebDriverConditions.url(config.getCoursesPageUrl()));
    }
    
    @Given("a user sees the courses list page")
    public void a_user_sees_the_courses_list_page() {
        Selenide.open(config.getCoursesPageUrl(), CoursesPage.class);
    }
    
    @When("the user clicks a present course name link")
    public void the_user_clicks_a_present_course_name_link() {
        coursesPage.findCouseLink(CoursesPage.PRESENT_COURSE_NAME)
                   .click();
    }
    
    @Then("the user clicks the create button")
    public void the_user_clicks_the_create_button() {
        coursesPage.findCreateButton().click();
    }
    
    @Then("the user enters a course name on the create course panel")
    public void the_user_enters_a_course_name_on_the_create_course_panel() {
        coursesPage.findCourseNameInputField().setValue(CoursePage.COURSE_NAME);
    }
    
    @Then("the user enters a course desctiption on the create course panel")
    public void the_user_enters_a_course_desctiption_on_the_create_course_panel() {
        coursesPage.findCourseDescriptionInputField()
                   .setValue(CoursesPage.COURSE_DESCRIPTION);
    }
    
    @Then("the user clicks the save changes button on the create course panel")
    public void the_user_clicks_the_save_changes_button_on_the_create_course_panel() {
        coursesPage.findSaveChangesButtonOfCreatePanel().click();
    }
    
    @Then("the created course is present on the courses list page")
    public void the_created_course_is_present_on_the_courses_list_page() {
        coursesPage.findCouseLink(CoursePage.COURSE_NAME).should(exist);
    }
    
    @Then("the course is not present on the courses list page")
    public void the_course_is_not_present_on_the_courses_list_page() {
        coursesPage.findCouseLink(CoursePage.COURSE_NAME).shouldNot(exist);
    }
    
    @When("the user clicks a course name link")
    public void the_user_clicks_a_course_name_link() {
        coursesPage.findCouseLink(CoursePage.COURSE_NAME).click();
    }
}
