package ua.com.foxminded.university.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoursePage {
    
    public static final String NEW_COURSE_DESCRIPTION = "new course description";
    public static final String NEW_COURSE_NAME = "Computer science";
    public static final String COURSE_PAGE_URL = "http://localhost:8080/courses/4";
    public static final String COURSE_PAGE_URL_REGEX = "http://localhost:8080/courses/\\d+";
    
    private By saveUpdatedChangesButton = By.id("saveUpdatedChanges");
    private By courseDescriptionUpdateField = By.id("courseDescriptionUpdate");
    private By courseNameUpdateField = By.id("courseNameUpdate");
    private WebDriver driver;

    public CoursePage(WebDriver driver) {
        this.driver = driver;
        
        if (!driver.getCurrentUrl().matches(COURSE_PAGE_URL_REGEX)) {
            throw new IllegalStateException("This is not the course page, " 
                    + "current page: " + driver.getCurrentUrl());
        }
    }
    
    public boolean isCourseDataPresent(String courseName, String description) {
        boolean isCourseName = !driver.findElements(By.xpath("//div[text()='" + 
                                                             courseName + "']"))
                                      .isEmpty();
        boolean isCourseDescription = !driver.findElements(By.xpath("//div[text()='" + 
                                                                    description + "']"))
                                             .isEmpty();
        return isCourseName || isCourseDescription;
    }
    
    public WebElement findSaveUpdatedChangesButton() {
        return driver.findElement(saveUpdatedChangesButton);
    }
    
    public WebElement findCourseDescriptionUpdateField() {
        return driver.findElement(courseDescriptionUpdateField);
    }
    
    public WebElement findCourseNameUpdateField() {
        return driver.findElement(courseNameUpdateField);
    }
}
