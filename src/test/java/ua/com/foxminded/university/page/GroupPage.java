package ua.com.foxminded.university.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroupPage {
    
    public static final int CREATED_GROUP_ORDER = 3;
    public static final String UPDATED_GROUP_NAME = "lf-71";
    public static final String EXISTENCE_GROUP_NAME = "ua-77";
    public static final int TIME_WAIT_VISIBILITY = 30;
    public static final String CREATED_GROUP_NAME = "df-85";
    
    @FindBy(id = "createButton")
    private WebElement createButton;
    
    @FindBy(id= "createCourseNameInput")
    private WebElement groupNameInputField;
    
    @FindBy(id = "createSubmitButton")
    private WebElement saveChangesButton;
    
    @FindBy(id = "groupUpdateNameField")
    private WebElement groupUpdateNameField;
    
    @FindBy(id = "nameUpdateButton")
    private WebElement nameUpdateButton;
    
    @FindBy(id = "confirmButton")
    private WebElement confirmButton;
    
    private WebDriver driver;

    public GroupPage(WebDriver driver) {
        this.driver = driver;
        AjaxElementLocatorFactory factory = 
                new AjaxElementLocatorFactory(driver, TIME_WAIT_VISIBILITY);
        PageFactory.initElements(factory, this);
    }
    
    public void waitForClickable(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    public WebElement findConfirmDeletingButtonByOrder(int order) {
        By confirmDeletingButton =By.xpath("//tbody//child::tr[" + order + 
                "]//*[@id='confirmDeleting']");
        waitForClickable(confirmDeletingButton);
        return driver.findElement(confirmDeletingButton);
    }
    
    public WebElement findDeleteButtonByGroupName(String name) {
        By deleteButton = By.xpath("//a[text()='" + name + 
                "']//ancestor::tr//*[@id='deleteButton']");
        return driver.findElement(deleteButton);
    }
    
    public void waitForLocatoring(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    
    public boolean isTextPresent(String text) {
        By textLocator = By.xpath("//div[text()='" + text + "']");
        waitForLocatoring(textLocator);
        return !driver.findElements(textLocator).isEmpty();
    }
    
    public WebElement findConfirmButton() {
        return confirmButton;
    }
    
    public WebElement findNameUpdateButton() {
        return nameUpdateButton;
    }
    
    public WebElement findLinkText(String text) {
        return driver.findElement(By.linkText(text));
    }
    
    public void updateGroupName(String name) {
        groupUpdateNameField.sendKeys(name);
    }
    
    public boolean groupNameIsNotPresent(String name) {
        By groupName = By.linkText(name);
        return driver.findElements(groupName).isEmpty();
    }
    
    public boolean isGroupNamePresent(String name) {
        By groupName = By.linkText(name);
        waitForLocatoring(groupName);
        return !driver.findElements(groupName).isEmpty();
    }
    
    public WebElement findSaveChangesButton() {
        return saveChangesButton;
    }
    
    public void enterGroupName(String name) {
        groupNameInputField.sendKeys(name);
    }
    
    public WebElement findCreateButton() { 
        return createButton;
    }
}
