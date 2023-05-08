package ua.com.foxminded.university.page;

import org.openqa.selenium.By;

import com.codeborne.selenide.Selenide;
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
        return Selenide.$x("//td[text()=" + userId + 
                "]//parent::tr//td[text()='" + authorityRepresentation + "']");
    }
    
    public SelenideElement findUpdatedUserAuthority(String email, String authorityRepresentation) {
        return Selenide.$x("//td[text()='" + email + 
                "']//parent::tr//td[text()='" + authorityRepresentation + "']");
    }
    
    public SelenideElement findAuthorizeButton(int userId) {
        return Selenide.$(By.id("authorizeButton" + userId));
    }
    
    public SelenideElement findSaveChangesButton(int userId) {
        return Selenide.$(By.id("saveChanges" + userId));
    }
    
    public void enterPassword(int userId, String password) {
        Selenide.$(By.id("password" + userId)).setValue(password);
        Selenide.$(By.id("confirmPassword" + userId)).setValue(password);
    }
    
    public SelenideElement findAuthorizeButtonOfAuthorizedMenu(int userId) {
        return Selenide.$(By.id("authorizeButtonOfAuthorizedMenu" + userId));
    }
    
    public void selectActiveStatusInAuthorizeMenu(Boolean status, int userId) {
        Selenide.$(By.id("authorizedActiveStatus" + userId))
                .selectOptionByValue(status.toString());
    }
    
    public void selectAuthorityInAuthorizeMenu(String authority, int userId) {
        Selenide.$(By.id("authorizedAuthority" + userId))
                .selectOptionByValue(authority);
    }

    public void selectAuthority(String authority, int userId) {
        Selenide.$(By.id("selectAuthority" + userId))
                .selectOptionByValue(authority);
    }
    
    public SelenideElement findEditButton(String email, int userId) {
        return Selenide.$x("//td[text()='" + email + 
                "']//parent::tr//button[@id='editButton" + userId + "']");
    }
}
