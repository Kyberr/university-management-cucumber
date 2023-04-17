package ua.com.foxminded.university.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoursesPage {
    
    public static final int COURSE_ID = 4;
    public static final String COURSE_DESCRIPTION = "some description";
    public static final String COURSE_NAME = "Data structures";
    public static final String COURSES_PAGE_URL = "http://localhost:8080/courses/list?";
    
    private WebDriver driver;
    private By createButton = By.id("createButton");
    private By createCourseNameInput = By.id("createCourseNameInput");
    private By createDescriptionInput = By.id("createDescriptionInput");
    private By saveChangesButtonOfCreatePanel = By.id("createSubmitButton");
    
    public CoursesPage(WebDriver driver) {
        this.driver = driver;
        
        if (!driver.getCurrentUrl().equals(COURSES_PAGE_URL)) {
            throw new IllegalStateException("This is not a courses page, " + 
                    "current page is: " + driver.getCurrentUrl().toString());
        }
    }
    
    public WebElement findConfirmDeletingButton(String courseName) {
        return driver.findElement(By.xpath("//div[text()='" + courseName + 
                "']//ancestor::form//button[@id='confirmDeletingButton']"));
    }
    
    public WebElement findDeleteCourseButton(String courseName) {
        return driver.findElement(By.xpath("//a[text()='" + courseName + 
                "']//ancestor::tr//button[@id='deleteCourseButton']"));
    }
    
    public WebElement findCouseLink(String couseName) {
        return driver.findElement(By.linkText(couseName));
    }
    
    public boolean isCoursePresent(String courseName) {
        return !driver.findElements(By.linkText(courseName)).isEmpty();
    }
    
    public WebElement findSaveChangesButtonOfCreatePanel() {
        return driver.findElement(saveChangesButtonOfCreatePanel);
    }
    
    public WebElement findCourseDescriptionInputField() {
        return driver.findElement(createDescriptionInput);
    }
    
    public WebElement findCourseNameInputField() {
        return driver.findElement(createCourseNameInput);
    }
    
    public WebElement findCreateButton() {
        return driver.findElement(createButton);
    }
}
