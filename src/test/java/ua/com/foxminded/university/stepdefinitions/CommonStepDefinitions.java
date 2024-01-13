package ua.com.foxminded.university.stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.codeborne.selenide.Selenide;

import io.cucumber.java.en.Then;

public class CommonStepDefinitions {
    
    public static final String ERROR_PAGE_TITLE = "Error page";
    
    @Then("the user request is denied")
    public void the_user_request_is_denied() {
        assertEquals(ERROR_PAGE_TITLE, Selenide.title());
    }
}
