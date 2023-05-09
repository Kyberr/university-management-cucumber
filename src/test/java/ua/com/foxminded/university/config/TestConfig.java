package ua.com.foxminded.university.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config.properties")
@EnableConfigurationProperties(PageUrlConfig.class)
public class TestConfig {
    
}
