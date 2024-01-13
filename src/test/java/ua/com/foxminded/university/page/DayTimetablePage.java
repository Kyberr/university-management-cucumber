package ua.com.foxminded.university.page;

import static com.codeborne.selenide.Selenide.*;

import java.time.Duration;
import java.time.LocalTime;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

public class DayTimetablePage {
    
    public SelenideElement findSaveCreatedTimetableButton() {
        return $x("(//button[@id='createSubmitButton'])[1]");
    }
    
    public void selectGroup(String groupName) {
        $x("(//select[@id='groupSelection'])[1]").selectOption(groupName);
    }
    
    public void selectLesson(String lessonName) {
        $x("(//select[@id='lessonSelection'])[1]").selectOption(lessonName);
    }
    
    public SelenideElement findCreateTimetableButton() {
        return $(By.id("createButton"));
    }
    
    public void selectBreakDuration(Duration duration) {
        $x("(//select[@id='breakDuration'])[1]")
        .selectOption(String.valueOf(duration.toMinutes()));
    }
    
    public void selectTime(LocalTime time) {
        $x("(//select[@id='startTime'])[1]").selectOption(time.toString());
    }
    
    public SelenideElement findConfirmDeletingButton(LocalTime startTime, 
                                                     String groupName, 
                                                     String lessonName) {
        return $x("//td[text()='" + startTime.toString() + 
                  "']//following-sibling::td[text()='" + groupName + 
                  "']//following-sibling::td[text()='" + lessonName + 
                  "']//parent::tr//child::button[@id='confirmDeletingButton']");
    }
    
    public SelenideElement findDeleteTimetableButton(LocalTime startTime, 
                                                     String groupName, 
                                                     String lessonName) {
        return $x("//td[text()='" + startTime.toString() + 
                  "']//following-sibling::td[text()='" + groupName + 
                  "']//following-sibling::td[text()='" + lessonName + 
                  "']//following-sibling::td//button[@id='deleteTimetableButton']");
    }
    
    public SelenideElement findDayTimetableEntry(LocalTime starTime, 
                                                 String groupName, 
                                                 String lesson) {
        String time = starTime.toString();
        return $x("//td[text()='" + time + 
                  "']//following::td[text()='" + groupName + 
                  "']//following::td[text()='" + lesson + "']");
    }
}
