package ua.com.foxminded.university.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ua.com.foxminded.university.config.PageUrlConfig;
import ua.com.foxminded.university.page.GroupPage;
import ua.com.foxminded.university.page.GroupsPage;

public class GroupsPageStepDefinitions {
    
    private PageUrlConfig config;
    private GroupsPage groupsPage;
    
    public GroupsPageStepDefinitions(PageUrlConfig config) {
        this.config = config;
        groupsPage = new GroupsPage();
    }
    
    @When("the user clicks the delete button of a present group")
    public void the_user_clicks_the_delete_button_of_a_present_group() {
        groupsPage.findDeleteButtonByGroupName(GroupPage.PRESENT_GROUP_NAME).click();
    }
    @Then("the user clicks the confirm button of a present group")
    public void the_user_clicks_the_confirm_button_of_a_present_group() {
        groupsPage.findConfirmDeletingButtonByGroupName(GroupPage.PRESENT_GROUP_NAME).click();
    }
    
    @Then("the user goes to groups list page")
    public void the_user_goes_to_groups_list_page() {
        Selenide.webdriver().shouldHave(
                WebDriverConditions.url(config.getGroupsPageUrl()));
    }
    
    @Then("the user clicks confirm button of the present group")
    public void the_user_clicks_confirm_button_of_the_present_group() {
        groupsPage.findConfirmDeletingButtonByGroupName(
                GroupsPage.PRESENT_GROUP_NAME).click();;
    }
    
    @When("the user clicks delete button of a present group")
    public void the_user_clicks_delete_button_of_a_present_group() {
        groupsPage.findDeleteButtonByGroupName(GroupsPage.PRESENT_GROUP_NAME).click();;
    }
    
    @Then("the deleted group is not present")
    public void the_deleted_group_is_not_present() {
        groupsPage.findLinkText(GroupPage.UPDATED_GROUP_NAME).shouldNot(Condition.exist);
    }
    
    @Then("the user clicks on the group name link")
    public void the_user_clicks_on_the_group_name_link() {
        groupsPage.findLinkText(GroupsPage.PRESENT_GROUP_NAME).click();
    }

    @Then("the user sees the created course on the group list page")
    public void the_user_sees_the_created_course_on_the_group_list_page() {
        groupsPage.findLinkText(GroupPage.CREATED_GROUP_NAME)
                 .should(Condition.exist);
    }
    
    @When("the user clicks on text link of the created group")
    public void the_user_clicks_on_text_link_of_the_created_group() {
        groupsPage.findLinkText(GroupPage.CREATED_GROUP_NAME).click();
    }
    
    @When("the user clicks the create group button")
    public void the_user_clicks_the_create_group_button() {
        groupsPage.findCreateButton().click();
    }
    
    @Then("the user clicks the confirm button of created group")
    public void the_user_clicks_the_confirm_button_of_created_group() {
        groupsPage.findConfirmDeletingButtonByOrder(GroupsPage.UPDATED_GROUP_ORDER).click();
    }
    
    @When("the user clicks the delete button of created group")
    public void the_user_clicks_the_delete_button_of_created_group() {
        groupsPage.findDeleteButtonByGroupName(GroupPage.UPDATED_GROUP_NAME).click();;
    }
    
    @Then("press the save changes button")
    public void press_the_save_changes_button() {
        groupsPage.findSaveChangesButton().click();
    }
    
    @Then("the user imputs a group name")
    public void the_user_imputs_a_group_name() {
        groupsPage.findGroupNameInputField()
                  .setValue(GroupPage.CREATED_GROUP_NAME);
    }

    @Given("a user sees the group list page")
    public void a_user_sees_the_group_list_page() {
        Selenide.open(config.getGroupsPageUrl());
    }
}
