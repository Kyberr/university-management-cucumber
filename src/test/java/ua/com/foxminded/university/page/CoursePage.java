package ua.com.foxminded.university.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CoursePage {
    
    public static final String UPDATED_COURSE_DESCRIPTION = "new course description";
    public static final String UPDATED_COURSE_NAME = "Computer science";
    public static final String COURSE_NAME = "Data structures"; 
    
    @FindBy(id = "courseNameUpdate")
    private WebElement courseNameUpdateField;
    
    @FindBy(id = "courseDescriptionUpdate")
    private WebElement courseDescriptionUpdateField;
    
    @FindBy(id = "saveUpdatedChanges")
    private WebElement saveUpdatedChangesButton;
    
    @FindBy(id = "assignButton")
    private WebElement assignButton; 
    
    @FindBy(id = "teacherSelect")
    private WebElement teacherSelect;
    
    @FindBy(id = "saveAssignmentButton")
    private WebElement saveAssignmentButton;
    
    private WebDriver driver;
    
    public CoursePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public WebElement findSssignButton() {
        return assignButton;
    }
    
    public boolean isCourseDataPresent(String courseName, String description) {
        By courseNameElement = By.xpath("//div[text()='" + courseName + "']");
        By courseDescriptionElement = By.xpath("//div[text()='" + description + "']");
        
        boolean isCourseName = !driver.findElements(courseNameElement).isEmpty();
        boolean isCourseDescription = !driver.findElements(courseDescriptionElement)
                                             .isEmpty();
        return isCourseName && isCourseDescription;
    }
    
    public WebElement findDeassignConfirmButtonByLastName(String lastName) {
        By deassignConfirmButton = By.xpath("//td[text()='" + lastName + 
                "']//parent::tr//child::button[@id='confirmDeassignButton']");
        return driver.findElement(deassignConfirmButton);
    }
    
    public boolean isTeacherPresent(String lastName) {
        By teacher = By.xpath("//td[text()='" + lastName + "']");
        return !driver.findElements(teacher).isEmpty();
    }
    
    public WebElement findSaveAssignmentButton() {
        return saveAssignmentButton;
    }
    
    public void selectTeacherByName(String name) {
        Select select = new Select(teacherSelect);
        select.selectByVisibleText(name);
    }
    
    public WebElement findDeassignTeacherButton(String lastName) {
        By deassignTeacherButton = By.xpath("//td[text()='" + lastName + 
                "']//parent::tr//child::button[@id='deassignTeacherButton']");
        return driver.findElement(deassignTeacherButton);
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
