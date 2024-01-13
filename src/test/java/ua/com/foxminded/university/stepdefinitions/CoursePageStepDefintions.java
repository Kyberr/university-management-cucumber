package ua.com.foxminded.university.stepdefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;

import io.cucumber.java.en.Then;
import ua.com.foxminded.university.config.PageUrlConfig;
import ua.com.foxminded.university.page.CoursePage;
import ua.com.foxminded.university.page.TeacherPage;

public class CoursePageStepDefintions {
    
    private CoursePage coursePage;
    private PageUrlConfig config;
    
    public CoursePageStepDefintions(PageUrlConfig config) {
        this.config = config;
        this.coursePage = new CoursePage();
    }
    
    @Then("the user goes to a course page")
    public void the_user_goes_to_a_course_page() {
        assertThat(WebDriverRunner.getWebDriver().getCurrentUrl())
                .matches(config.getCoursePageUrlRegex());
    }
    
    @Then("the user clicks the assign teacher button")
    public void the_user_clicks_the_assign_teacher_button() {
        coursePage.findAssignButton().click();
    }
    
    @Then("the user select a teacher to a course")
    public void the_user_select_a_teacher_to_a_course() {
        coursePage.selectTeacherByName(TeacherPage.TEACHER_NAME);
    }
    
    @Then("the user clicks the save changes button")
    public void the_user_clicks_the_save_changes_button() {
        coursePage.findSaveAssignmentButton().click();
    }
    
    @Then("the user sees the selected teacher on the course page")
    public void the_user_sees_the_selected_teacher_on_the_course_page() {
        coursePage.checkTeacherPresence(TeacherPage.ASSIGNED_TEACHER_LAST_NAME)
                  .should(Condition.exist);
    }
    
    @Then("the user clicks the deassign teacher button")
    public void the_user_clicks_the_deassign_teacher_button() {
        coursePage.findDeassignTeacherButton(
                TeacherPage.ASSIGNED_TEACHER_LAST_NAME).click();
    }
    
    @Then("the user clicks the deassign confirm button")
    public void the_user_clicks_the_deassign_confirm_button() {
        coursePage.findDeassignConfirmButtonByLastName(
                TeacherPage.ASSIGNED_TEACHER_LAST_NAME).click();
    }
    
    @Then("the couse page has no the deassigned teacher")
    public void the_couse_page_has_no_the_deassigned_teacher() {
        coursePage.checkTeacherPresence(TeacherPage.ASSIGNED_TEACHER_LAST_NAME)
                  .shouldNot(Condition.exist);
    }
    
    @Then("the user enters a new course name into the input field")
    public void the_user_enters_a_new_course_name_into_the_input_field() {
        coursePage.findCourseNameUpdateField()
                  .setValue(CoursePage.UPDATED_COURSE_NAME);
    }
    
    @Then("the user enters new course description into the input field")
    public void the_user_enters_new_course_description_into_the_input_field() {
        coursePage.findCourseDescriptionUpdateField()
                  .setValue(CoursePage.UPDATED_COURSE_DESCRIPTION);
    }
    
    @Then("the user clicks the save changes button on the course page")
    public void the_user_clicks_the_save_changes_button_on_the_course_page() {
        coursePage.findSaveUpdatedChangesButton()
                  .click();
    }
    
    @Then("the user sees updated couse data on the course page")
    public void the_user_sees_updated_couse_data_on_the_course_page() {
        coursePage.findCourseName(CoursePage.UPDATED_COURSE_NAME)
                  .should(Condition.exist);
        coursePage.findCourseDescription(CoursePage.UPDATED_COURSE_DESCRIPTION)
                  .should(Condition.exist);
    }
}
