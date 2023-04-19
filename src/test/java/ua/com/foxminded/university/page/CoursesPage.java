package ua.com.foxminded.university.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CoursesPage {
    
    public static final int COURSE_ID = 4;
    public static final String COURSE_DESCRIPTION = "some description";
    public static final String COURSE_NAME = "Data structures";
    
    @FindBy(id = "createButton")
    private WebElement createButton;
    
    @FindBy(id = "createCourseNameInput")
    private WebElement createCourseNameInput;
    
    @FindBy(id = "createDescriptionInput")
    private WebElement createCourseDescriptionInput;
    
    @FindBy(id = "createSubmitButton")
    private WebElement saveChangesButtonOfCreatePnale;
    
    private WebDriver driver;

    public CoursesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    

    public WebElement findConfirmDeletingButton(String courseName) {
        By confirmDeletingButton = By.xpath("//div[text()='" + courseName + 
                "']//ancestor::form//button[@id='confirmDeletingButton']");
        return driver.findElement(confirmDeletingButton);
    }
    
    public WebElement findDeleteCourseButton(String courseName) {
        By deleteCourseButton = By.xpath("//a[text()='" + courseName + 
                "']//ancestor::tr//button[@id='deleteCourseButton']");
        return driver.findElement(deleteCourseButton);
    }
    
    public WebElement findCouseLink(String couseName) {
        return driver.findElement(By.linkText(couseName));
    }
    
    public boolean isCoursePresent(String courseName) {
        return !driver.findElements(By.linkText(courseName)).isEmpty();
    }
    
    public WebElement findSaveChangesButtonOfCreatePanel() {
        return saveChangesButtonOfCreatePnale;
    }
    
    public WebElement findCourseDescriptionInputField() {
        return createCourseDescriptionInput;
    }
    
    public WebElement findCourseNameInputField() {
        return createCourseNameInput;
    }
    
    public WebElement findCreateButton() {
        return createButton;
    }
}
