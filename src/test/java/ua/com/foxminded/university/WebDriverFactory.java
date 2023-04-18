package ua.com.foxminded.university;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class WebDriverFactory {

    public static final String FIREFOX = "firefox";
    public static final String CHROME = "chrome";
    
    private static WebDriverFactory driverFactory;
    private WebDriver driver;
    
    
    private WebDriverFactory() {
        String webdriver = System.getProperty(CHROME, FIREFOX);

        switch (webdriver) {
        case FIREFOX:
            driver = new FirefoxDriver();
            break;
        case CHROME:
            driver = new ChromeDriver();
            break;
        default:
            throw new RuntimeException("Unsupported webdriver");
        }
    }
    
    public static WebDriverFactory getInstance() {
        if (driverFactory == null) {
            driverFactory = new WebDriverFactory();
        }
        return driverFactory;
    }
    
    public synchronized WebDriver getDriver() {
        return driver;
    }
}
