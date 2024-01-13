package ua.com.foxminded.university.stepdefinitions;

import static org.assertj.core.api.Assertions.assertThat;
import static ua.com.foxminded.university.page.MonthTimetablePage.*;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;

import io.cucumber.java.en.Then;
import ua.com.foxminded.university.config.PageUrlConfig;
import ua.com.foxminded.university.page.DayTimetablePage;
import ua.com.foxminded.university.page.MonthTimetablePage;

public class DayTimetablePageStepDefinitions {
    
    private PageUrlConfig config;
    private DayTimetablePage dayTimetablePage;
    
    public DayTimetablePageStepDefinitions(PageUrlConfig config) {
        this.config = config;
        this.dayTimetablePage = new DayTimetablePage();
    }
    
    @Then("the user selects time on a day timetable page")
    public void the_user_selects_time_on_a_day_timetable_page() {
        dayTimetablePage.selectTime(MonthTimetablePage.FIRST_LESSON_TIME);
    }
    @Then("the user selects a break duration time on a day timetable page")
    public void the_user_selects_a_break_duration_time_on_a_day_timetable_page() {
        dayTimetablePage.selectBreakDuration(MonthTimetablePage.BREAK_DURATION);
    }
    @Then("the user selects the programming lesson on a day timetable page")
    public void the_user_selects_the_programming_lesson_on_a_day_timetable_page() {
        dayTimetablePage.selectLesson(MonthTimetablePage.PROGRAMMING_LESSON);
    }
    @Then("the user selects a group name on a day timetable page")
    public void the_user_selects_a_group_name_on_a_day_timetable_page() {
        dayTimetablePage.selectGroup(MonthTimetablePage.GROUP_NAME);
    }
    @Then("the user clicks the timetable save changes button on a day timetable page")
    public void the_user_clicks_the_timetable_save_changes_button_on_a_day_timetable_page() {
        dayTimetablePage.findSaveCreatedTimetableButton().click();
    }
    
    @Then("the user clicks the confirm deleting button")
    public void the_user_clicks_the_confirm_deleting_button() {
        dayTimetablePage.findConfirmDeletingButton(FIRST_LESSON_TIME, 
                                                   GROUP_NAME, 
                                                   PROGRAMMING_LESSON).click();
    }
    
    @Then("the user clicks the delete button of the created timetable")
    public void the_user_clicks_the_delete_button_of_the_created_timetable() {
        
        dayTimetablePage.findDeleteTimetableButton(FIRST_LESSON_TIME, 
                                                   GROUP_NAME, 
                                                   PROGRAMMING_LESSON).click();
    }
    @Then("the deleted timetable is not present on a day timetable")
    public void the_deleted_timetable_is_not_present_on_a_day_timetable() {
        dayTimetablePage.findDayTimetableEntry(FIRST_LESSON_TIME, 
                                               GROUP_NAME, 
                                               PROGRAMMING_LESSON)
                        .shouldNot(Condition.exist);
    }
    
    @Then("the user click create timetable button on a day timetable page")
    public void the_user_click_create_timetable_button_on_a_day_timetable_page() {
        dayTimetablePage.findCreateTimetableButton().click();
    }
    
    @Then("the user goes to a day timetable page")
    public void the_user_goes_to_a_day_timetable_page() {
        assertThat(WebDriverRunner.getWebDriver().getCurrentUrl())
            .matches(config.getDayTimetableUrlRegex());
    }
    
    @Then("the created timetable presents on a day timetable page")
    public void the_created_timetable_presents_on_a_day_timetable_page() {
        dayTimetablePage.findDayTimetableEntry(FIRST_LESSON_TIME, 
                                               GROUP_NAME, 
                                               PROGRAMMING_LESSON)
                        .should(Condition.exist);
    }
    
    @Then("the user goes to the created day timetable")
    public void the_user_goes_to_the_created_day_timetable() {
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertThat(currentUrl).matches(config.getDayTimetableUrlRegex());
    }
}
