package ua.com.foxminded.university.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import io.cucumber.java.After;
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
    
    public Hooks(PageUrlConfig config) {
        this.config = config;
        this.loginPage = new LoginPage();
        this.homePage = new HomePage();
        this.coursesPage = new CoursesPage();
    }
    
    @After("@courseUpdatingByStaff")
    public void deleteUpdatedByStaffCourse() {
        Selenide.open(config.getLoginPageUrl());
        loginPage.enterCredentials(LoginPage.ADMIN_LOGIN, LoginPage.PASSWORD);
        loginPage.findSignInButton().click();
        homePage.findCoursesButton().click();
        coursesPage.findDeleteCourseButton(CoursePage.UPDATED_COURSE_NAME).click();
        coursesPage.findConfirmDeletingButton(CoursePage.UPDATED_COURSE_NAME).click();
        coursesPage.findCouseLink(CoursePage.UPDATED_COURSE_NAME).shouldNot(Condition.exist);
    }
}
