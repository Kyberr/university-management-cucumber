package ua.com.foxminded.university.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties
@Getter
@Setter
public class PageUrlConfig {
    
    private String adminPageUrl;
    private String loginPageUrl;
    private String homePageUrl;
    private String groupsPageUrl;
    private String groupPageUrlRegex;
    private String coursesPageUrl;
    private String coursePageUrlRegex;
    private String hostUrl;
    private String dayTimetableUrlRegex;
}
