package ua.com.foxminded.university.page;


import org.openqa.selenium.By;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class CoursesPage {
    
    public static final int COURSE_ID = 4;
    public static final String COURSE_DESCRIPTION = "some description";
    public static final String PRESENT_COURSE_NAME = "Programming";
    
    
    public SelenideElement findConfirmDeletingButton(String courseName) {
        return Selenide.$x("//div[text()='" + courseName + 
                "']//ancestor::form//button[@id='confirmDeletingButton']");
    }
    
    public SelenideElement findDeleteCourseButton(String courseName) {
        return Selenide.$x("//a[text()='" + courseName + 
                "']//ancestor::tr//button[@id='deleteCourseButton']");
    }
    
    public SelenideElement findCouseLink(String couseName) {
        return Selenide.$(By.linkText(couseName));
    }
    
    public SelenideElement findSaveChangesButtonOfCreatePanel() {
        return Selenide.$(By.id("createSubmitButton"));
    }
    
    public SelenideElement findCourseDescriptionInputField() {
        return Selenide.$(By.id("createDescriptionInput"));
    }
    
    public SelenideElement findCourseNameInputField() {
        return Selenide.$(By.id("createCourseNameInput"));
    }
    
    public SelenideElement findCreateButton() {
        return Selenide.$(By.id("createButton"));
    }
}
