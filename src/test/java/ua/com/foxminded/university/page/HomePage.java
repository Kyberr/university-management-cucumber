package ua.com.foxminded.university.page;

import org.openqa.selenium.By;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class HomePage {
    
    public static final By ADMIN_PANEL_BUTTON = By.id("adminPanelButton");
    public static final By COURSES_BUTTON = By.id("coursesButton");
    public static final By TIMETABLES_BUTTON = By.id("timetablesButton");
    
    public SelenideElement findTimetablesButton() {
        return Selenide.$(TIMETABLES_BUTTON);
    }
    
    public SelenideElement findGroupsButton() {
        return Selenide.$(By.id("groupsButton"));
    }

    public SelenideElement findCoursesButton() {
        return Selenide.$(COURSES_BUTTON);
    }
    
    public SelenideElement findAdminPanelButton() {
        return Selenide.$(ADMIN_PANEL_BUTTON);
    }
    
    public SelenideElement findSignInButton() {
        return Selenide.$(By.id("signInButton"));
    }
}
