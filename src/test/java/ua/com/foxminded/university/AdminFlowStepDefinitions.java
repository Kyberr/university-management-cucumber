package ua.com.foxminded.university;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminFlowStepDefinitions {

    public static final String CONFIRM_DELETING_BUTTON_ID = "confirmDeletingButton";
    public static final String DELETE_BUTTON_ID = "deleteButton";
    public static final String SHIPMENT_CREATED_BUTTON_ID = "create-submit";
    public static final String COURSE_DESCRIPTION_INPUT_FIELD_ID = "description";
    public static final String COURSE_NAME_INPUT_FIELD_ID = "floatingInput";
    public static final String CREATE_BUTTON_ID = "createButton";
    public static final String UPDATE_BUTTON_ID = "update-submit";
    public static final String COURSE_DESCRIPTION_UPDATE_INPUT_ID = "courseDescriptionUpdate";
    public static final String COURSE_NAME_UPDATE_INPUT_ID = "courseNameUpdate";
    public static final String COURSE_PAGE_URL_REGEX = "http://localhost:8080/courses/\\d+";
    public static final String COURSES_LIST_PAGE = "http://localhost:8080/courses/list";
    public static final String COURSE_DESCRIPTION = "some description";
    public static final String UPDATED_COURSE_NAME = "Computer systems";
    public static final String COURSE_NAME = "Physics";
    public static final String LOGIN_BUTTON_XPATH = "//input[@value='SignIn']";
    public static final String ADMIN_PASSWORD = "a";
    public static final String ADMIN_AUTHORITIES_LOGIN = "a";
    public static final String LOGIN_PAGE = "http://localhost:8080/login";
    public static final String PASSWORD_INPUT_ELEMENT_NAME = "password";
    public static final String LOGIN_INPUT_ELEMENT_NAME = "username";

    public static WebDriver webDriver;
    
    @BeforeAll
    public static void setUp() {
        webDriver = WebDriverFactory.createWebDriver();
        
    }

    @Given("A user has the admin authorities")
    public void a_user_has_the_admin_authorities() {
        webDriver.get(LOGIN_PAGE);
        WebElement login = webDriver.findElement(By.name(LOGIN_INPUT_ELEMENT_NAME));
        login.sendKeys(ADMIN_AUTHORITIES_LOGIN);
        WebElement password = webDriver.findElement(By.name(PASSWORD_INPUT_ELEMENT_NAME));
        password.sendKeys(ADMIN_PASSWORD);
        webDriver.findElement(By.xpath(LOGIN_BUTTON_XPATH)).click();
    }

    @When("the user does create")
    public void the_user_does_create() {
        webDriver.get(COURSES_LIST_PAGE);
        WebElement createButton = webDriver.findElement(By.id(CREATE_BUTTON_ID));
        createButton.click();
        WebElement courseName = webDriver.findElement(By.id(COURSE_NAME_INPUT_FIELD_ID));
        courseName.sendKeys(COURSE_NAME);
        WebElement courseDescription = webDriver.findElement(
                By.id(COURSE_DESCRIPTION_INPUT_FIELD_ID));
        courseDescription.sendKeys(COURSE_DESCRIPTION);
        WebElement submitButton = webDriver.findElement(By.id(SHIPMENT_CREATED_BUTTON_ID));
        submitButton.click();
    }

    @Then("the course becomes created")
    public void the_course_becomes_created() {
        WebElement createdCourseName = webDriver.findElement(By.linkText(COURSE_NAME));
        assertEquals(COURSE_NAME, createdCourseName.getText());
    }
    
    @When("the user does get")
    public void the_user_does_get() {
        webDriver.get(COURSES_LIST_PAGE);
        WebElement courseLink = webDriver.findElement(By.linkText(COURSE_NAME));
        courseLink.click();
    }
    
    @Then("the course becomes recieved")
    public void the_course_becomes_recieved() {
        String currentUrl = webDriver.getCurrentUrl();
        assertTrue(currentUrl.matches(COURSE_PAGE_URL_REGEX));
    }
    
    @When("the user does update")
    public void the_user_does_update() {
        webDriver.get(COURSES_LIST_PAGE);
        WebElement courseLink = webDriver.findElement(By.linkText(COURSE_NAME));
        courseLink.click();
        WebElement courseNameInput = webDriver.findElement(
            By.id(COURSE_NAME_UPDATE_INPUT_ID));
        courseNameInput.sendKeys(UPDATED_COURSE_NAME);
        WebElement courseDescriptionInput = webDriver.findElement(
            By.id(COURSE_DESCRIPTION_UPDATE_INPUT_ID));
        courseDescriptionInput.sendKeys(COURSE_DESCRIPTION);
        WebElement updateButton = webDriver.findElement(By.id(UPDATE_BUTTON_ID));
        updateButton.click();
    }
    
    @Then("the course becomes updated")
    public void the_course_becomes_updated() {
        webDriver.get(COURSES_LIST_PAGE);
        WebElement courseLink = webDriver.findElement(By.linkText(UPDATED_COURSE_NAME));
        assertTrue(courseLink.isDisplayed());
    }
    
    @When("the user does delete")
    public void the_user_does_delete() {
        webDriver.get(COURSES_LIST_PAGE);
        String deleteButtonPath = "//a[text()='" + UPDATED_COURSE_NAME 
                + "']//parent::td//parent::tr//button";
        WebElement deleteButton = webDriver.findElement(By.xpath(deleteButtonPath));
        deleteButton.click();
        WebElement confirmDeletingButton = webDriver.findElement(
            By.id(CONFIRM_DELETING_BUTTON_ID));
        confirmDeletingButton.submit();
    }
    @Then("the course becomes deleted")
    public void the_course_becomes_deleted() {
        webDriver.get(COURSES_LIST_PAGE);
        List<WebElement> courseLink = webDriver.findElements(By.linkText(UPDATED_COURSE_NAME));
        assertTrue(courseLink.isEmpty());
    }
    
    @AfterAll
    public static void cleanUp() {
        webDriver.close();
    }
}
