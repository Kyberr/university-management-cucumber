package ua.com.foxminded.university.stepdefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import com.codeborne.selenide.WebDriverRunner;

import io.cucumber.java.en.Then;
import ua.com.foxminded.university.config.PageUrlConfig;

public class DayTimetablePageStepDefinitions {
    
    private PageUrlConfig config;
    
    public DayTimetablePageStepDefinitions(PageUrlConfig config) {
        this.config = config;
    }
    
    @Then("the user goes to the created day timetable")
    public void the_user_goes_to_the_created_day_timetable() {
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertThat(currentUrl).matches(config.getDayTimetableUrlRegex());
    }
}
