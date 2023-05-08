package ua.com.foxminded.university.page;

import org.openqa.selenium.By;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class LoginPage {
    
    public static final String TEACHER_LOGIN = "teacher";
    public static final String STUDENT_LOGIN = "student";
    public static final String STAFF_LOGIN = "staff";
    public static final String ADMIN_LOGIN = "a";
    public static final String PASSWORD = "a";
    
    public static final By LOGIN_BUTTON_LOCATOR = By.id("signInButton");
    public static final By PASSWORD_LOCATOR = By.name("password");
    public static final By USERNAME_LOCATOR = By.name("username");
    
    public SelenideElement findSignInButton() {
        return Selenide.$(LOGIN_BUTTON_LOCATOR);
    }
    
    public void enterCredentials(String username, String password) {
        Selenide.$(USERNAME_LOCATOR).setValue(username);
        Selenide.$(PASSWORD_LOCATOR).setValue(password);
    }
}
