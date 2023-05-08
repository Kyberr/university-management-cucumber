package ua.com.foxminded.university.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ua.com.foxminded.university.config.PageUrlConfig;
import ua.com.foxminded.university.page.HomePage;

public class HomePageStepDefinitions {
    
    private PageUrlConfig config;
    private HomePage homePage;
    
    public HomePageStepDefinitions(PageUrlConfig config) {
        this.config = config;
        this.homePage = new HomePage();
    }
    
    @Given("a user on the home page")
    public void a_user_on_the_home_page() {
        Selenide.open(config.getHomePageUrl());
    }
    
    @When("the user clicks the SignIn button on the home page")
    public void the_user_clicks_the_SignIn_button_the_home_page() {
        homePage.findSignInButton().click();
    }
    
    @Given("a not authorized user has connection to the home page")
    public void a_user_has_connection_to_the_home_page() {
        Selenide.open(config.getHomePageUrl());
    }
    
    @When("the user clicks the courses button")
    public void the_user_clicks_the_courses_button() {
        homePage.findCoursesButton().click();
    }
    
    @When("the user clicks the admin panel button on the home page")
    public void the_user_clicks_the_admin_panel_button_on_the_home_page() {
        homePage.findAdminPanelButton().click();
    }
    
    @When("the user clicks on the groups button")
    public void the_user_clicks_on_the_groups_button() {
        homePage.findGroupsButton().click();
    }
    
    @Given("the user sees the admin panel button on the home page")
    public void the_user_sees_the_admin_panel_button_on_the_home_page() {
        Selenide.$(homePage.findAdminPanelButton()).should(Condition.exist);
    }
    
    @Then("the user goes to the home page")
    public void the_user_goes_to_the_home_page() {
        Selenide.webdriver().shouldHave(WebDriverConditions.url(config.getHomePageUrl()));
    }
    
    @Given("a user clicks the timetables button on the home page")
    public void a_user_clicks_the_timetables_button_on_the_home_page() {
        Selenide.open(config.getHomePageUrl(), HomePage.class);
        homePage.findTimetablesButton().click();
    }
    
    @Given("a user sees the courses button on the home page")
    public void a_user_sees_the_courses_button_on_the_home_page() {
        homePage.findCoursesButton().should(Condition.exist);
    }
}
