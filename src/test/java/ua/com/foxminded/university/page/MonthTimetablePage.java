package ua.com.foxminded.university.page;

import java.time.Duration;
import java.time.LocalTime;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class MonthTimetablePage {
    
    public static final int FIRST_NODE_INDEX = 1;
    public static final String PROGRAMMING_LESSON = "Programming";
    public static final String CREATE_BUTTON_LOCATOR = "(//button[@id='createButton'])[1]";
    public static final String TIME_SELECTION_LOCATOR = "(//select[@id='startTime'])[1]";
    public static final String BREAK_DURATION_SELECTION_LOCATOR = 
            "(//select[@id='breakDuration'])[1]";
    public static final String LESSON_SELECTION_LOCATOR = "(//select[@id='lessonSelection'])[1]";
    public static final String GROUP_SELECTION_LOCATOR = "(//select[@id='groupSelection'])[1]";
    public static final String SAVE_CREATED_TIMETABLE_BUTTON_LOCATOR = 
            "(//button[@id='createSubmitButton'])[1]";
    public static final LocalTime FIRST_LESSON_TIME = LocalTime.of(8, 0);
    public static final Duration BREAK_DURATION = Duration.ofMinutes(15);
    public static final String GROUP_NAME = "ua-77";
    
    public SelenideElement findSaveCreatedTimetableButton() {
        return Selenide.$x(SAVE_CREATED_TIMETABLE_BUTTON_LOCATOR);
    }
    
    public void selectGroup(String groupName) {
        Selenide.$x(GROUP_SELECTION_LOCATOR).selectOption(groupName);
    }
    
    public void selectLesson(String lessonName) {
        Selenide.$x(LESSON_SELECTION_LOCATOR).selectOption(lessonName);
    }
    
    public void selectBreakDuration(Duration duration) {
        Selenide.$x(BREAK_DURATION_SELECTION_LOCATOR)
                .selectOption(String.valueOf(duration.toMinutes()));
    }
    
    public void selectTime(LocalTime time) {
        Selenide.$x(TIME_SELECTION_LOCATOR).selectOption(time.toString());
    }
    
    public SelenideElement findCreateDayTimetableButton() {
        return Selenide.$x(CREATE_BUTTON_LOCATOR);
    }
}
