package ua.com.foxminded.university.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    
    private WebDriver driver;
    
    public AdminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public boolean isAuthorizedUserPresent(int userId, String authorityRepresentation) {
        By authorizedUser = By.xpath("//td[text()=" + userId + 
                "]//parent::tr//td[text()='" + authorityRepresentation + "']");
        return !driver.findElements(authorizedUser).isEmpty();
    }
    
    public boolean isUpdatedUserAuthorityPresent(String email, String authorityRepresentation) {
        By updatedUserAuthority = By.xpath("//td[text()='" + email + 
                "']//parent::tr//td[text()='" + authorityRepresentation + "']");
        return !driver.findElements(updatedUserAuthority).isEmpty();
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
        By passwordField = By.id("password" + userId + "");
        By confirmPassField = By.id("confirmPassword" + userId + "");
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPassField).sendKeys(password);
    }
    
    public WebElement findAuthorizeButtonOfAuthorizedMenu(int userId) {
        By authorizeButton = By.id("authorizeButtonOfAuthorizedMenu" + userId + "");
        return driver.findElement(authorizeButton);
    }
    
    public void selectActiveStatusInAuthorizeMenu(Boolean status, int userId) {
        By activeStatus = By.id("authorizedActiveStatus" + userId + "");
        WebElement selectElement = driver.findElement(activeStatus);
        Select select = new Select(selectElement);
        select.selectByValue(status.toString());
    }
    
    public void selectAuthorityInAuthorizeMenu(String authority, int userId) {
        By authoritySelect = By.id("authorizedAuthority" + userId + "");
        WebElement selectElement = driver.findElement(authoritySelect);
        Select select = new Select(selectElement);
        select.selectByValue(authority);
    }

    public void selectAuthority(String authority, int userId) {
        By authoritySelect = By.id("selectAuthority" + userId + "");
        WebElement selectElement = driver.findElement(authoritySelect);
        Select select = new Select(selectElement);
        select.selectByValue(authority);
    }
    
    public WebElement findEditButton(String email, int userId) {
        By editButton = By.xpath("//td[text()='" + email + 
                "']//parent::tr//button[@id='editButton" + userId + "']");
        return  driver.findElement(editButton);
    }
}
