package ua.com.foxminded.university.page;

import static com.codeborne.selenide.Selenide.*;

import java.time.Duration;
import java.time.LocalTime;

import com.codeborne.selenide.SelenideElement;

public class MonthTimetablePage {
    
    public static final int FIRST_NODE_INDEX = 1;
    public static final String MATHEMATICS_LESSON = "Mathematics";
    public static final String PROGRAMMING_LESSON = "Programming";
    public static final LocalTime FIRST_LESSON_TIME = LocalTime.of(8, 0);
    public static final Duration BREAK_DURATION = Duration.ofMinutes(15);
    public static final String GROUP_NAME = "ua-77";
    
    public void selectLesson(String lessonName) {
        $x("(//select[@id='lessonSelection'])[1]").selectOption(lessonName);
    }
    
    public SelenideElement findExpandButton() {
        return $x("(//button[@id='expandButton'])[1]");
    }
    
    public SelenideElement findSaveCreatedTimetableButton() {
        return $x("(//button[@id='createSubmitButton'])[1]");
    }
    
    public void selectGroup(String groupName) {
        $x("(//select[@id='groupSelection'])[1]").selectOption(groupName);
    }
    
    public void selectBreakDuration(Duration duration) {
        $x("(//select[@id='breakDuration'])[1]")
        .selectOption(String.valueOf(duration.toMinutes()));
    }
    
    public void selectTime(LocalTime time) {
        $x("(//select[@id='startTime'])[1]").selectOption(time.toString());
    }
    
    public SelenideElement findCreateDayTimetableButton() {
        return $x("(//button[@id='createButton'])[1]");
    }
}
