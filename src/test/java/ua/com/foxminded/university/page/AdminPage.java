package ua.com.foxminded.university.page;

import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

public class AdminPage {
    
    public static final int NOT_AUTHORIZED_USER_ID = 6;
    public static final int USER_ID = 5;
    public static final String EMAIL = "person";
    public static final String STAFF_AUTHORITY = "STAFF";
    public static final boolean ENABLED_STATUS = true;
    public static final String STUDENT_AUTHORITY = "STUDENT";
    public static final String ADMIN_AUTHORITY = "ADMIN";
    public static final String STAFF_AUTHORITY_REPRESENTATION = "Staff";
    public static final String ADMIN_AUTHORITY_REPRESENTATION = "Admin";
    
    public SelenideElement findAuthorizedUser(int userId, String authorityRepresentation) {
        return $x("//td[text()=" + userId + 
                  "]//parent::tr//td[text()='" + authorityRepresentation + "']");
    }
    
    public SelenideElement findUpdatedUserAuthority(String email, String authorityRepresentation) {
        return $x("//td[text()='" + email + 
                  "']//parent::tr//td[text()='" + authorityRepresentation + "']");
    }
    
    public SelenideElement findAuthorizeButton(int userId) {
        return $(By.id("authorizeButton" + userId));
    }
    
    public SelenideElement findSaveChangesButton(int userId) {
        return $(By.id("saveChanges" + userId));
    }
    
    public void enterPassword(int userId, String password) {
        $(By.id("password" + userId)).setValue(password);
        $(By.id("confirmPassword" + userId)).setValue(password);
    }
    
    public SelenideElement findAuthorizeButtonOfAuthorizedMenu(int userId) {
        return $(By.id("authorizeButtonOfAuthorizedMenu" + userId));
    }
    
    public void selectActiveStatusInAuthorizeMenu(Boolean status, int userId) {
        $(By.id("authorizedActiveStatus" + userId)).selectOptionByValue(status.toString());
    }
    
    public void selectAuthorityInAuthorizeMenu(String authority, int userId) {
        $(By.id("authorizedAuthority" + userId)).selectOptionByValue(authority);
    }

    public void selectAuthority(String authority, int userId) {
        $(By.id("selectAuthority" + userId)).selectOptionByValue(authority);
    }
    
    public SelenideElement findEditButton(String email, int userId) {
        return $x("//td[text()='" + email + 
                  "']//parent::tr//button[@id='editButton" + userId + "']");
    }
}
