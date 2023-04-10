package ua.com.foxminded.university;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    
    public static final String FIREFOX = "firefox";
    public static final String CHROME = "chrome";
    
    
    public static WebDriver createWebDriver() {
        String webdriver = System.getProperty(CHROME, FIREFOX);
        
        switch (webdriver) {
        case FIREFOX:
            return new FirefoxDriver();
        case CHROME:
            return new ChromeDriver();
        default:
            throw new RuntimeException("Unsuppoeted webdirver");
        }
    }
}
