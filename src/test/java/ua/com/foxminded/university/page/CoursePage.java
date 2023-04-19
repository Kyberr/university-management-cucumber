package ua.com.foxminded.university.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoursePage {
    
    public static final String COURSE_TITLE = "Course";
    public static final String NEW_COURSE_DESCRIPTION = "new course description";
    public static final String NEW_COURSE_NAME = "Computer science";
    public static final String COURSE_NAME = "Data structures"; 
    
    @FindBy(id = "courseNameUpdate")
    private WebElement courseNameUpdateField;
    
    @FindBy(id = "courseDescriptionUpdate")
    private WebElement courseDescriptionUpdateField;
    
    @FindBy(id = "saveUpdatedChanges")
    private WebElement saveUpdatedChangesButton;
    
    private WebDriver driver;
    
    public CoursePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isCourseDataPresent(String courseName, String description) {
        By courseNameElement = By.xpath("//div[text()='" + courseName + "']");
        By courseDescriptionElement = By.xpath("//div[text()='" + description + "']");
        
        boolean isCourseName = !driver.findElements(courseNameElement).isEmpty();
        boolean isCourseDescription = !driver.findElements(courseDescriptionElement)
                                             .isEmpty();
        return isCourseName || isCourseDescription;
    }
    
    public WebElement findSaveUpdatedChangesButton() {
        return saveUpdatedChangesButton;
    }
    
    public WebElement findCourseDescriptionUpdateField() {
        return courseDescriptionUpdateField;
    }
    
    public WebElement findCourseNameUpdateField() {
        return courseNameUpdateField;
    }
}
