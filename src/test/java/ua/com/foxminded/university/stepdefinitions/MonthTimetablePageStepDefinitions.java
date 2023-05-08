package ua.com.foxminded.university.stepdefinitions;

import java.time.LocalDate;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverConditions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ua.com.foxminded.university.config.PageUrlConfig;
import ua.com.foxminded.university.page.MonthTimetablePage;

public class MonthTimetablePageStepDefinitions {
    
    public static final LocalDate DATESTAMP = LocalDate.now();
    
    private MonthTimetablePage monthTimetablePage;
    private String monthTimetablePageUrl;
    
    public MonthTimetablePageStepDefinitions(PageUrlConfig config) {
        monthTimetablePageUrl = new StringBuffer().append(config.getHostUrl())
                                                  .append("/timetables/")
                                                  .append(DATESTAMP)
                                                  .append("/list")
                                                  .append("?").toString();
        monthTimetablePage = new MonthTimetablePage();
    }
    
    @When("a user goes to a month timetable")
    public void a_user_goes_to_a_month_timetable() {
        Selenide.webdriver().shouldHave(WebDriverConditions.url(monthTimetablePageUrl));
    }
    
    @Then("the user clicks the timetable create button of any day")
    public void the_user_clicks_the_timetable_create_button_of_any_day() {
        monthTimetablePage.findCreateDayTimetableButton().click();
    }
    
    @Then("the user selects time")
    public void the_user_selects_time() {
        monthTimetablePage.selectTime(MonthTimetablePage.FIRST_LESSON_TIME);
    }
    
    @Then("the user selects a break duration time")
    public void the_user_selects_a_break_duration_time() {
        monthTimetablePage.selectBreakDuration(MonthTimetablePage.BREAK_DURATION);
    }
    
    @Then("the user selects a lesson")
    public void the_user_selects_a_lesson() {
        monthTimetablePage.selectLesson(MonthTimetablePage.PROGRAMMING_LESSON);
    }
    
    @Then("the user selects a group name")
    public void the_user_selects_a_group_name() {
        monthTimetablePage.selectGroup(MonthTimetablePage.GROUP_NAME);
    }
    
    @Then("the user clicks the timetable save changes button")
    public void the_user_clicks_the_timetable_save_changes_button() {
        monthTimetablePage.findSaveCreatedTimetableButton().click();
    }
}
