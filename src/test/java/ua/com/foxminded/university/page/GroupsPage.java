package ua.com.foxminded.university.page;


import org.openqa.selenium.By;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class GroupsPage {
    
    public static final String PRESENT_GROUP_NAME = "ua-77";
    public static final int CREATED_GROUP_ORDER = 3;
    
    public SelenideElement findConfirmDeletingButtonByGroupName(String name) {
        return Selenide.$x("//a[text()='" + name + 
                "']//ancestor::tr//child::button[@id='confirmDeleting']");
    }
    
    public SelenideElement findLinkText(String text) {
        return Selenide.$(By.linkText(text));
    }
    
    public SelenideElement findSaveChangesButton() {
        return Selenide.$(By.id("createSubmitButton"));
    }
    
    public SelenideElement findGroupNameInputField() {
        return Selenide.$(By.id("createCourseNameInput"));
    }
    
    public SelenideElement findCreateButton() { 
        return Selenide.$(By.id("createButton"));
    }
    
    public SelenideElement findDeleteButtonByGroupName(String name) {
        return Selenide.$x("//a[text()='" + name + 
                "']//ancestor::tr//*[@id='deleteButton']");
    }
    
    public SelenideElement findConfirmDeletingButtonByOrder(int order) {
        return Selenide.$x("//tbody//child::tr[" + order + 
                "]//*[@id='confirmDeleting']");
    }
}
