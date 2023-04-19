package ua.com.foxminded.university.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:config.properties")
public class TestConfig {
    
    public static final String FIREFOX = "firefox";
    public static final String CHROME = "chrome";
    
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public WebDriver driver() {
        WebDriver driver;
        String webdriver = System.getProperty(CHROME, FIREFOX);

        switch (webdriver) {
        case FIREFOX:
            driver = new FirefoxDriver();
            return driver;
        case CHROME:
            driver = new ChromeDriver();
            return driver;
        default:
            throw new RuntimeException("Unsupported webdriver");
        }
    }
}
