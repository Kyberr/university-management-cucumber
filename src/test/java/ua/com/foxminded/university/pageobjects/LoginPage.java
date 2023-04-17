package ua.com.foxminded.university.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    
    public static final String LOGIN_PAGE_URL = "http://localhost:8080/login";
    
    private WebDriver driver;
    
    private By usernameLocator = By.name("username");
    private By passwordLocator = By.name("password");
    private By loginButtonLocator = By.xpath("//input[@value='SignIn']");
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        
        if (!driver.getCurrentUrl().equals(LOGIN_PAGE_URL)) {
            throw new IllegalStateException("This is not the login page, " + 
                    "current page is: " + driver.getCurrentUrl());
        }
    }
    
    public String getUserName() {
        return driver.findElement(usernameLocator).getAttribute("value");
    }
    
    public WebElement findSignInButton() {
        return driver.findElement(loginButtonLocator);
    }
    
    public void enterCredentials(String username, String password) {
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
    }
}
