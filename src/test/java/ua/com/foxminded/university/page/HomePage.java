package ua.com.foxminded.university.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HomePage {
    
    public static final By ADMIN_PANEL_BUTTON = By.id("adminPanelButton");
    public static final By COURSES_BUTTON = By.id("coursesButton");
    
    @FindBy(id = "signInButton")
    private WebElement signInButton;
    
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isCoursesButtonPresent() {
        return !driver.findElements(COURSES_BUTTON).isEmpty();
    }
    
    public WebElement findCoursesButton() {
        return driver.findElement(COURSES_BUTTON);
    }
    
    public boolean isAdminPanelPresent() {
        return !driver.findElements(ADMIN_PANEL_BUTTON).isEmpty();
    }
    
    public WebElement findAdminPanelButton() {
        return driver.findElement(ADMIN_PANEL_BUTTON);
    }
    
    public WebElement findSignInButton() {
        return signInButton;
    }
}
