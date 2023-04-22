package ua.com.foxminded.university.stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import ua.com.foxminded.university.config.PageUrlConfig;
import ua.com.foxminded.university.page.CoursePage;
import ua.com.foxminded.university.page.CoursesPage;
import ua.com.foxminded.university.page.HomePage;
import ua.com.foxminded.university.page.LoginPage;

public class Hooks {
    
    private PageUrlConfig config;
    private LoginPage loginPage;
    private HomePage homePage;
    private CoursesPage coursesPage; 
    private WebDriver driver;
    
    public Hooks(WebDriver driver, PageUrlConfig config) {
        this.driver = driver;
        this.config = config;
        this.loginPage = PageFactory.initElements(driver, LoginPage.class);
        this.homePage = PageFactory.initElements(driver, HomePage.class);
        this.coursesPage = PageFactory.initElements(driver, CoursesPage.class);
    }

    @Before
    public void setUp() {
        driver.manage().deleteAllCookies();
    }
    
    @After("@courseUpdatingByStaff")
    public void deleteUpdatedByStaffCourse() {
        driver.get(config.getLoginPageUrl());
        loginPage.enterCredentials(LoginPage.ADMIN_LOGIN, LoginPage.PASSWORD);
        loginPage.findSignInButton().click();
        homePage.findCoursesButton().click();
        coursesPage.findDeleteCourseButton(CoursePage.UPDATED_COURSE_NAME).click();
        coursesPage.findConfirmDeletingButton(CoursePage.UPDATED_COURSE_NAME).click();
        assertFalse(coursesPage.isCoursePresent(CoursePage.UPDATED_COURSE_NAME));
    }
}
