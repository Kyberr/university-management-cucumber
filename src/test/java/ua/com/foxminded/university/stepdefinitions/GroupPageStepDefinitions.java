package ua.com.foxminded.university.stepdefinitions;

import static com.codeborne.selenide.Condition.exist;
import static org.assertj.core.api.Assertions.assertThat;
import static ua.com.foxminded.university.page.StudentsPage.LAST_NAME_PARKER;
import static ua.com.foxminded.university.page.StudentsPage.LAST_NAME_STARK;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;

import io.cucumber.java.en.Then;
import ua.com.foxminded.university.config.PageUrlConfig;
import ua.com.foxminded.university.page.GroupPage;
import ua.com.foxminded.university.page.StudentsPage;

public class GroupPageStepDefinitions {
    
    private GroupPage groupPage;
    private PageUrlConfig config;
    
    public GroupPageStepDefinitions(PageUrlConfig config) {
        this.config = config;
        this.groupPage = new GroupPage();
    }
    
    @Then("the user clicks deassign button of a student")
    public void the_user_click_deassign_button_of_a_student() {
        groupPage.findDeassignButtonByStudentLastName(LAST_NAME_PARKER)
                 .click();
    }
    @Then("the student is absent in the students list of the group page")
    public void the_user_is_absent_in_the_students_list_of_the_group_page() {
        groupPage.findDeassignButtonByStudentLastName(LAST_NAME_PARKER).shouldNot(exist);
    }
    
    @Then("the user click the add student button")
    public void the_user_click_the_add_student_button() {
        groupPage.findAddStudentButton().click();
    }
    
    @Then("the user selects students")
    public void the_user_selects_students() {
        groupPage.selectStudent(LAST_NAME_PARKER).setSelected(true);
        groupPage.selectStudent(LAST_NAME_STARK).setSelected(true);
    }
    
    @Then("the user clicks the save selected students button")
    public void the_user_clicks_the_save_selected_students_button() {
        groupPage.findSaveSelectedStudentsButton().click();
    }
    
    @Then("the user sees added students on the group page")
    public void the_user_sees_added_students_on_the_group_page() {
        groupPage.findDeassignButtonByStudentLastName(StudentsPage.LAST_NAME_PARKER)
                 .should(exist);
        groupPage.findDeassignButtonByStudentLastName(StudentsPage.LAST_NAME_STARK)
                 .should(exist);
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
