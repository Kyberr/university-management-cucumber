package ua.com.foxminded.university.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LoginPage {
    
    public static final String TEACHER_LOGIN = "teacher";
    public static final String STUDENT_LOGIN = "student";
    public static final String STAFF_LOGIN = "staff";
    public static final String ADMIN_LOGIN = "a";
    public static final String PASSWORD = "a";
    
    @FindBy(xpath = "//input[@value='SignIn']")
    private WebElement loginButtonLocator;
    
    @FindBy(name = "password")
    private WebElement passwordLocator;
    
    @FindBy(name = "username")
    private WebElement usernameLocator; 
    
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
    public String getUserName() {
        return usernameLocator.getAttribute("value");
    }
    
    public WebElement findSignInButton() {
        return loginButtonLocator;
    }
    
    public void enterCredentials(String username, String password) {
        usernameLocator.sendKeys(username);
        passwordLocator.sendKeys(password);
    }
}
