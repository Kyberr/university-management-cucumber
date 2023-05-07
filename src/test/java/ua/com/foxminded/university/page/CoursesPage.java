package ua.com.foxminded.university.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CoursesPage {
    
    public static final int COURSE_ID = 4;
    public static final String COURSE_DESCRIPTION = "some description";
    public static final String EXISTENCE_COURSE_NAME = "Programming";
    
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
    
    public void waitForClickable(WebElement element ) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.elementToBeClickable(element));
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
        WebElement link = driver.findElement(By.linkText(couseName));
        waitForClickable(link);
        return link;
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
