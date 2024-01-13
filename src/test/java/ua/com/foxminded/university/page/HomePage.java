package ua.com.foxminded.university.page;

import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

public class HomePage {
    
    public SelenideElement findTimetablesButton() {
        return $(By.id("timetablesButton"));
    }
    
    public SelenideElement findGroupsButton() {
        return $(By.id("groupsButton"));
    }

    public SelenideElement findCoursesButton() {
        return $(By.id("coursesButton"));
    }
    
    public SelenideElement findAdminPanelButton() {
        return $(By.id("adminPanelButton"));
    }
    
    public SelenideElement findSignInButton() {
        return $(By.id("signInButton"));
    }
}
