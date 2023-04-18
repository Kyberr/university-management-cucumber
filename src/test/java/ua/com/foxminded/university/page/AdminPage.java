package ua.com.foxminded.university.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {
    
    public static final int NOT_AUTHORIZED_USER_ID = 6;
    public static final int USER_ID = 5;
    public static final String EMAIL = "person";
    public static final String ADMIN_PAGE_URL = "http://localhost:8080/users/list?";
    public static final String STAFF_AUTHORITY = "STAFF";
    public static final boolean ENABLED_STATUS = true;
    public static final String STUDENT_AUTHORITY = "STUDENT";
    public static final String ADMIN_AUTHORITY = "ADMIN";
    public static final String STAFF_AUTHORITY_REPRESENTATION = "Staff";
    public static final String ADMIN_AUTHORITY_REPRESENTATION = "Admin";
    
    private WebDriver driver;
    
    public AdminPage(WebDriver driver) {
        this.driver = driver;
        
        if (!driver.getCurrentUrl().equals(ADMIN_PAGE_URL)) {
            throw new IllegalStateException("This is not the admin page, " + 
                    "current page is: " + driver.getCurrentUrl());
        }
    }
    
    public boolean isAuthorizedUserPresent(int userId, String authorityRepresentation) {
        return !driver.findElements(By.xpath("//td[text()=" + userId + 
                                    "]//parent::tr//td[text()='" + authorityRepresentation + 
                                    "']"))
                      .isEmpty();
        
    }
    
    public boolean isUpdatedUserAuthorityPresent(String email, String authorityRepresentation) {
        return !driver.findElements(By.xpath("//td[text()='" + email + 
                                    "']//parent::tr//td[text()='" + 
                                    authorityRepresentation + "']"))
                      .isEmpty();
    }
    
    public WebElement findAuthorizeButton(int userId) {
        return driver.findElement(By.id("authorizeButton" + userId + ""));
    }
    
    public WebElement findSaveChangesButton(int userId) {
        return driver.findElement(By.id("saveChanges" + userId + ""));
    }
    
    public void waitForClickable(WebElement element ) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.elementToBeClickable(element));
    }
    
    public void enterPassword(int userId, String password) {
         WebElement passwordField =  driver.findElement(By.id("password" + userId + ""));
         passwordField.sendKeys(password);
         WebElement confirmPasswordField = driver.findElement(
                 By.id("confirmPassword" + userId + ""));
         confirmPasswordField.sendKeys(password);
    }
    
    public WebElement findAuthorizeButtonOfAuthorizedMenu(int userId) {
        return driver.findElement(By.id("authorizeButtonOfAuthorizedMenu" + userId + ""));
    }
    
    public void selectActiveStatusInAuthorizeMenu(Boolean status, int userId) {
        WebElement selectElement = driver.findElement(
                By.id("authorizedActiveStatus" + userId + ""));
        Select select = new Select(selectElement);
        select.selectByValue(status.toString());
    }
    
    public void selectAuthorityInAuthorizeMenu(String authority, int userId) {
        WebElement selectElement = driver.findElement(By.id(
                "authorizedAuthority" + userId + ""));
        Select select = new Select(selectElement);
        select.selectByValue(authority);
    }
    
    public void selectAuthority(String authority, int userId) {
        WebElement selectAuthorityElement = driver.findElement(
                By.id("selectAuthority" + userId + ""));
        Select select = new Select(selectAuthorityElement);
        select.selectByValue(authority);
    }
    
    public WebElement findEditButton(String email, int userId) {
        return  driver.findElement(By.xpath("//td[text()='" + email + 
                                            "']//parent::tr//button[@id='editButton" + 
                                            userId + "']"));
    }
}
