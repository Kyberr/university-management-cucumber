package ua.com.foxminded.university.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import ua.com.foxminded.university.config.PageUrlConfig;
import ua.com.foxminded.university.page.CoursePage;
import ua.com.foxminded.university.page.CoursesPage;
import ua.com.foxminded.university.page.GroupPage;
import ua.com.foxminded.university.page.GroupsPage;
import ua.com.foxminded.university.page.HomePage;
import ua.com.foxminded.university.page.LoginPage;

public class Hooks {
    
    private PageUrlConfig config;
    private LoginPage loginPage;
    private HomePage homePage;
    private CoursesPage coursesPage; 
    private GroupsPage groupsPage;
    
    public Hooks(PageUrlConfig config) {
        this.config = config;
        this.loginPage = new LoginPage();
        this.homePage = new HomePage();
        this.coursesPage = new CoursesPage();
        this.groupsPage = new GroupsPage();
    }
    
    @Before
    public void claenUp() {
        WebDriverRunner.clearBrowserCache();
    }
    
    @After("@staffUpdatesGroup")
    public void deleteCreatedByStaffGroup() {
        loginWithAdminRole();
        homePage.findGroupsButton().click();
        groupsPage.findDeleteButtonByGroupName(GroupPage.UPDATED_GROUP_NAME).click();
        groupsPage.findConfirmDeletingButtonByOrder(GroupsPage.UPDATED_GROUP_ORDER).click();
        groupsPage.findLinkText(GroupPage.UPDATED_GROUP_NAME).shouldNot(Condition.exist);
    }
    
    @After("@courseUpdatingByStaff")
    public void deleteUpdatedByStaffCourse() {
        loginWithAdminRole();
        homePage.findCoursesButton().click();
        coursesPage.findDeleteCourseButton(CoursePage.UPDATED_COURSE_NAME).click();
        coursesPage.findConfirmDeletingButton(CoursePage.UPDATED_COURSE_NAME).click();
        coursesPage.findCouseLink(CoursePage.UPDATED_COURSE_NAME).shouldNot(Condition.exist);
    }
    
    private void loginWithAdminRole() {
        Selenide.open(config.getLoginPageUrl());
        loginPage.enterCredentials(LoginPage.ADMIN_LOGIN, LoginPage.PASSWORD);
        loginPage.findSignInButton().click();
    }
}
