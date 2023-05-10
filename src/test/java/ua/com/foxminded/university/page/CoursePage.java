package ua.com.foxminded.university.page;

import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

public class CoursePage {
    
    public static final String UPDATED_COURSE_DESCRIPTION = "new course description";
    public static final String UPDATED_COURSE_NAME = "Computer science";
    public static final String COURSE_NAME = "Data structures"; 
    
    public SelenideElement findAssignButton() {
        return $(By.id("assignButton"));
    }
    
    public SelenideElement findCourseName(String name) {
        return $x("//div[text()='" + name + "']");
    }
    
    public SelenideElement findCourseDescription(String description) {
        return $x("//div[text()='" + description + "']");
    }

    public SelenideElement findDeassignConfirmButtonByLastName(String lastName) {
        return $x("//td[text()='" + lastName + 
                  "']//parent::tr//child::button[@id='confirmDeassignButton']");
    }
    
    public SelenideElement checkTeacherPresence(String lastName) {
        return $x("//td[text()='" + lastName + "']");
    }
    
    public SelenideElement findSaveAssignmentButton() {
        return $(By.id("saveAssignmentButton"));
    }
    
    public void selectTeacherByName(String name) {
        $(By.id("teacherSelect")).selectOption(name);
    }
    
    public SelenideElement findDeassignTeacherButton(String lastName) {
        return $x("//td[text()='" + lastName + 
                  "']//parent::tr//child::button[@id='deassignTeacherButton']");
    }
    
    public SelenideElement findSaveUpdatedChangesButton() {
        return $(By.id("saveUpdatedChanges"));
    }
    
    public SelenideElement findCourseDescriptionUpdateField() {
        return $(By.id("courseDescriptionUpdate"));
    }
    
    public SelenideElement findCourseNameUpdateField() {
        return $(By.id("courseNameUpdate"));
    }
}
