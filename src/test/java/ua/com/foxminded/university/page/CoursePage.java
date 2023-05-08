package ua.com.foxminded.university.page;

import org.openqa.selenium.By;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class CoursePage {
    
    public static final String UPDATED_COURSE_DESCRIPTION = "new course description";
    public static final String UPDATED_COURSE_NAME = "Computer science";
    public static final String COURSE_NAME = "Data structures"; 
    
    public SelenideElement findAssignButton() {
        return Selenide.$(By.id("assignButton"));
    }
    
    public SelenideElement findCourseName(String name) {
        return Selenide.$x("//div[text()='" + name + "']");
    }
    
    public SelenideElement findCourseDescription(String description) {
        return Selenide.$x("//div[text()='" + description + "']");
    }

    public SelenideElement findDeassignConfirmButtonByLastName(String lastName) {
        return Selenide.$x("//td[text()='" + lastName + 
                "']//parent::tr//child::button[@id='confirmDeassignButton']");
    }
    
    public SelenideElement checkTeacherPresence(String lastName) {
        return Selenide.$x("//td[text()='" + lastName + "']");
    }
    
    public SelenideElement findSaveAssignmentButton() {
        return Selenide.$(By.id("saveAssignmentButton"));
    }
    
    public void selectTeacherByName(String name) {
        Selenide.$(By.id("teacherSelect")).selectOption(name);
    }
    
    public SelenideElement findDeassignTeacherButton(String lastName) {
        return Selenide.$x("//td[text()='" + lastName + 
                "']//parent::tr//child::button[@id='deassignTeacherButton']");
    }
    
    public SelenideElement findSaveUpdatedChangesButton() {
        return Selenide.$(By.id("saveUpdatedChanges"));
    }
    
    public SelenideElement findCourseDescriptionUpdateField() {
        return Selenide.$(By.id("courseDescriptionUpdate"));
    }
    
    public SelenideElement findCourseNameUpdateField() {
        return Selenide.$(By.id("courseNameUpdate"));
    }
}
