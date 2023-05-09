package ua.com.foxminded.university.page;

import org.openqa.selenium.By;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class GroupPage {
    
    public static final String PRESENT_GROUP_NAME = "ua-77";
    public static final String UPDATED_GROUP_NAME = "km-71";
    public static final int TIME_WAIT_VISIBILITY = 30;
    public static final String CREATED_GROUP_NAME = "df-85";
    
    public SelenideElement findGroupName(String text) {
        return Selenide.$x("//div[text()='" + text + "']");
    }
    
    public SelenideElement findConfirmButton() {
        return Selenide.$(By.id("confirmButton"));
    }
    
    public SelenideElement findNameUpdateButton() {
        return Selenide.$(By.id("nameUpdateButton"));
    }
    
    public SelenideElement findGroupNameUpdateField() {
        return Selenide.$(By.id("groupUpdateNameField"));
    }
}
