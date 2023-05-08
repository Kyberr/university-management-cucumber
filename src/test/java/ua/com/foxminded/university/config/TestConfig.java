package ua.com.foxminded.university.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:config.properties")
@EnableConfigurationProperties(PageUrlConfig.class)
public class TestConfig {
    
    public static final String FIREFOX_DEF_VALUE = "firefox";
    public static final String CHROME_KEY = "chrome";
    
//    @Bean
//    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
//    public WebDriver driver() {
//        WebDriver driver;
//        String webdriver = System.getProperty(CHROME_KEY, FIREFOX_DEF_VALUE);
//
//        switch (webdriver) {
//        case FIREFOX_DEF_VALUE:
//            driver = new FirefoxDriver();
//            return driver;
//        case CHROME_KEY:
//            driver = new ChromeDriver();
//            return driver;
//        default:
//            throw new RuntimeException("Unsupported webdriver");
//        }
//    }
}
