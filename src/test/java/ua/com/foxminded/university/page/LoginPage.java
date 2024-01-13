package ua.com.foxminded.university.page;

import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

public class LoginPage {
    
    public static final String TEACHER_LOGIN = "teacher";
    public static final String STUDENT_LOGIN = "student";
    public static final String STAFF_LOGIN = "staff";
    public static final String ADMIN_LOGIN = "a";
    public static final String PASSWORD = "a";
    
    public SelenideElement findSignInButton() {
        return $(By.id("signInButton"));
    }
    
    public void enterCredentials(String username, String password) {
        $(By.name("username")).setValue(username);
        $(By.name("password")).setValue(password);
    }
}
