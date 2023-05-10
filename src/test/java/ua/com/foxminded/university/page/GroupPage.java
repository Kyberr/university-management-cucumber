package ua.com.foxminded.university.page;

import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

public class GroupPage {
    
    public static final String PRESENT_GROUP_NAME = "ua-77";
    public static final String UPDATED_GROUP_NAME = "km-71";
    public static final int TIME_WAIT_VISIBILITY = 30;
    public static final String CREATED_GROUP_NAME = "df-85";
    
    public SelenideElement findGroupName(String text) {
        return $x("//div[text()='" + text + "']");
    }
    
    public SelenideElement findConfirmButton() {
        return $(By.id("confirmButton"));
    }
    
    public SelenideElement findNameUpdateButton() {
        return $(By.id("nameUpdateButton"));
    }
    
    public SelenideElement findGroupNameUpdateField() {
        return $(By.id("groupUpdateNameField"));
    }
}
