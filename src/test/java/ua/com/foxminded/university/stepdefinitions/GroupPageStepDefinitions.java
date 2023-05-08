package ua.com.foxminded.university.stepdefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;

import io.cucumber.java.en.Then;
import ua.com.foxminded.university.config.PageUrlConfig;
import ua.com.foxminded.university.page.GroupPage;

public class GroupPageStepDefinitions {
    
    private GroupPage groupPage;
    private PageUrlConfig config;
    
    public GroupPageStepDefinitions(PageUrlConfig config) {
        this.config = config;
        this.groupPage = new GroupPage();
    }
    
    @Then("the user goes to a group page")
    public void the_user_goes_to_a_group_page() {
        assertThat(WebDriverRunner.getWebDriver().getCurrentUrl())
            .matches(config.getGroupPageUrlRegex());
    }
    
    @Then("the user sees the updated group name in the group page")
    public void the_user_sees_the_updated_group_name_in_the_group_page() {
        groupPage.findGroupName(GroupPage.UPDATED_GROUP_NAME).should(Condition.exist);
    }
    
    @Then("the user clicks the confirm button")
    public void the_user_clicks_the_confirm_button() {
        groupPage.findConfirmButton().click();
    }
    
    @Then("the user clicks on the update group button")
    public void the_user_clicks_on_the_update_group_button() {
        groupPage.findNameUpdateButton().click();;
    }
    
    @Then("the user inputs a group name to the group name field")
    public void the_user_inputs_a_group_name_to_the_group_name_field() {
        groupPage.findGroupNameUpdateField().setValue(GroupPage.UPDATED_GROUP_NAME);
    }
}
