package ua.com.foxminded.university.stepdefinitions;

import static com.codeborne.selenide.Condition.*;
import static ua.com.foxminded.university.page.StudentsPage.*;

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
import ua.com.foxminded.university.page.StudentsPage;

public class Hooks {
    
    private PageUrlConfig config;
    private LoginPage loginPage;
    private HomePage homePage;
    private CoursesPage coursesPage; 
    private GroupsPage groupsPage;
    private GroupPage groupPage;
    
    public Hooks(PageUrlConfig config) {
        this.config = config;
        this.loginPage = new LoginPage();
        this.homePage = new HomePage();
        this.coursesPage = new CoursesPage();
        this.groupsPage = new GroupsPage();
        this.groupPage = new GroupPage();
    }
    
    @Before
    public void claenUp() {
        WebDriverRunner.clearBrowserCache();
    }
    
    @Before("@adminDeassignsStudent or @studentDeassignsStudent or @teacherDeassignsStudent" + 
            " or @staffDeassignsStudent")
    public void assignStudentToGroup() {
        loginWithAdminRole();
        Selenide.open(config.getGroupsPageUrl());
        groupsPage.findLinkText(GroupPage.PRESENT_GROUP_NAME).click();
        groupPage.findAddStudentButton().click();
        groupPage.selectStudent(LAST_NAME_PARKER).setSelected(true);
        groupPage.findSaveSelectedStudentsButton().click();
        groupPage.findDeassignButtonByStudentLastName(StudentsPage.LAST_NAME_PARKER)
                 .should(exist);
    }
    
    @After("@adminAssignsStudents or @staffAssignsStudents")
    public void deassignStudentsToGroup() {
        Selenide.open(config.getGroupsPageUrl());
        groupsPage.findLinkText(GroupPage.PRESENT_GROUP_NAME).click();
        groupPage.findDeassignButtonByStudentLastName(LAST_NAME_PARKER).click();
        groupPage.findDeassignButtonByStudentLastName(LAST_NAME_PARKER).shouldNot(exist);
        groupPage.findDeassignButtonByStudentLastName(LAST_NAME_STARK).click();
        groupPage.findDeassignButtonByStudentLastName(LAST_NAME_STARK).shouldNot(exist);
    }
    
    @After("@studentDeassignsStudent or @teacherDeassignsStudent")
    public void deassignStudentToGroup() {
        Selenide.open(config.getGroupsPageUrl());
        groupsPage.findLinkText(GroupPage.PRESENT_GROUP_NAME).click();
        groupPage.findDeassignButtonByStudentLastName(LAST_NAME_PARKER).click();
        groupPage.findDeassignButtonByStudentLastName(LAST_NAME_PARKER).shouldNot(exist);
    }
    
    @Before("@adminDeletesCourse or @adminUpdatesCourse or @staffUpdatesCourse")
    public void createCourse() {
        loginWithAdminRole();
        homePage.findCoursesButton().click();
        coursesPage.findCreateButton().click();
        coursesPage.findCourseNameInputField().setValue(CoursePage.COURSE_NAME);
        coursesPage.findSaveChangesButtonOfCreatePanel().click();
        coursesPage.findCouseLink(CoursePage.COURSE_NAME).should(exist);
    }
    
    @After("@staffUpdatesCourse or @adminUpdatesCourse")
    public void deleteUpdatedCourse() {
        loginWithAdminRole();
        homePage.findCoursesButton().click();
        coursesPage.findDeleteCourseButton(CoursePage.UPDATED_COURSE_NAME).click();
        coursesPage.findConfirmDeletingButton(CoursePage.UPDATED_COURSE_NAME).click();
        coursesPage.findCouseLink(CoursePage.UPDATED_COURSE_NAME).shouldNot(exist);
    }
    
    @After("@adminCreatesCourse or @staffCreatesCourse") 
    public void deleteCreatedCourse() {
        loginWithAdminRole();
        homePage.findCoursesButton().click();
        coursesPage.findDeleteCourseButton(CoursePage.COURSE_NAME).click();
        coursesPage.findConfirmDeletingButton(CoursePage.COURSE_NAME).click();
        coursesPage.findCouseLink(CoursePage.COURSE_NAME).shouldNot(exist);
    }
    
    @Before("@staffUpdatesGroup or @adminUpdatesGroup or @adminDeletsGroup")
    public void createGroup() {
        loginWithAdminRole();
        homePage.findGroupsButton().click();
        groupsPage.findCreateButton().click();
        groupsPage.findGroupNameInputField().setValue(GroupPage.GROUP_NAME);
        groupsPage.findSaveChangesButton().click();
        groupsPage.findLinkText(GroupPage.GROUP_NAME).should(exist);
    }
    
    @After("@staffUpdatesGroup or @adminUpdatesGroup")
    public void deleteUpdatedGroup() {
        loginWithAdminRole();
        homePage.findGroupsButton().click();
        groupsPage.findDeleteButtonByGroupName(GroupPage.UPDATED_GROUP_NAME).click();
        groupsPage.findConfirmDeletingButtonByOrder(GroupPage.UPDATED_GROUP_NAME).click();
        groupsPage.findLinkText(GroupPage.UPDATED_GROUP_NAME).shouldNot(exist);
    }
    
    @After("@adminCreatesGroup or @staffCreatesGroup")
    public void deleteCreatedGroup() {
        loginWithAdminRole();
        Selenide.open(config.getGroupsPageUrl());
        groupsPage.findDeleteButtonByGroupName(GroupPage.GROUP_NAME).click();
        groupsPage.findConfirmDeletingButtonByOrder(GroupPage.GROUP_NAME).click();
        groupsPage.findLinkText(GroupPage.GROUP_NAME).shouldNot(exist);
    }

    private void loginWithAdminRole() {
        Selenide.open(config.getLoginPageUrl());
        loginPage.enterCredentials(LoginPage.ADMIN_LOGIN, LoginPage.PASSWORD);
        loginPage.findSignInButton().click();
    }
}
