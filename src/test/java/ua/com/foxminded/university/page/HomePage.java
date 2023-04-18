package ua.com.foxminded.university.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    
    public static final String HOME_PAGE_URL = "http://localhost:8080/";
    
    private By adminPanelButton = By.id("adminPanelButton");
    private WebDriver driver;
    private By signInButton = By.id("signInButton");
    private By coursesButton = By.id("coursesButton");
    
    public HomePage(WebDriver driver) {
        this.driver = driver;
        
        if (!driver.getCurrentUrl().equals(HOME_PAGE_URL)) {
            throw new IllegalStateException("This is not the home page, " + 
                    "current page is: " + driver.getCurrentUrl());
        }
    }
    
    public boolean isCoursesButtonPresent() {
        return !driver.findElements(coursesButton).isEmpty();
    }
    
    public WebElement findCoursesButton() {
        return driver.findElement(coursesButton);
    }
    
    public AdminPage clickAdminPanelButton() {
        driver.findElement(adminPanelButton).click();
        return new AdminPage(driver);
    }
    
    public boolean isAdminPanelPresent() {
        return !driver.findElements(adminPanelButton).isEmpty();
    }
    
    public WebElement findAdminPanelButton() {
        return driver.findElement(adminPanelButton);
    }
    
    public LoginPage clickLoginButton() {
        driver.findElement(signInButton).click();;
        return new LoginPage(driver);
    }
}
