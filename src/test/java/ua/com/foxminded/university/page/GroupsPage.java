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

public class GroupsPage {
    
    public static final String PRESENT_GROUP_NAME = "ua-77";
    public static final int CREATED_GROUP_ORDER = 3;
    
    @FindBy(id = "createButton")
    private WebElement createButton;
    
    @FindBy(id= "createCourseNameInput")
    private WebElement groupNameInputField;
    
    @FindBy(id = "createSubmitButton")
    private WebElement saveChangesButton;
    
    private WebDriver driver;

    public GroupsPage(WebDriver driver) {
        this.driver = driver;
        AjaxElementLocatorFactory factory = 
                new AjaxElementLocatorFactory(driver, GroupPage.TIME_WAIT_VISIBILITY);
        PageFactory.initElements(factory, this);
    }
    
    public WebElement findConfirmDeletingButtonByGroupName(String name) {
        By deleteButton = By.xpath("//a[text()='" + name + 
                "']//ancestor::tr//child::button[@id='confirmDeleting']");
        return driver.findElement(deleteButton);
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
    
    public WebElement findDeleteButtonByGroupName(String name) {
        By deleteButton = By.xpath("//a[text()='" + name + 
                "']//ancestor::tr//*[@id='deleteButton']");
        return driver.findElement(deleteButton);
    }
    
    public WebElement findConfirmDeletingButtonByOrder(int order) {
        By confirmDeletingButton =By.xpath("//tbody//child::tr[" + order + 
                "]//*[@id='confirmDeleting']");
        waitForClickable(confirmDeletingButton);
        return driver.findElement(confirmDeletingButton);
    }

    private void waitForClickable(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.elementToBeClickable(locator));
    }
}