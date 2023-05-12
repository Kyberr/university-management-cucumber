package ua.com.foxminded.university.page;

import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

public class GroupsPage {
    
    public static final String PRESENT_GROUP_NAME = "ua-77";
    
    public SelenideElement findConfirmDeletingButtonByGroupName(String name) {
        return $x("//a[text()='" + name + 
                "']//ancestor::tr//child::button[@id='confirmDeleting']");
    }
    
    public SelenideElement findLinkText(String text) {
        return $(By.linkText(text));
    }
    
    public SelenideElement findSaveChangesButton() {
        return $(By.id("createSubmitButton"));
    }
    
    public SelenideElement findGroupNameInputField() {
        return $(By.id("createCourseNameInput"));
    }
    
    public SelenideElement findCreateButton() { 
        return $(By.id("createButton"));
    }
    
    public SelenideElement findDeleteButtonByGroupName(String name) {
        return $x("//a[text()='" + name + 
                  "']//ancestor::tr//*[@id='deleteButton']");
    }
    
    public SelenideElement findConfirmDeletingButtonByOrder(String name) {
        return $x("//a[text()='" + name + 
                  "']//ancestor::tr//descendant::button[@id='confirmDeleting']");
    }
}
