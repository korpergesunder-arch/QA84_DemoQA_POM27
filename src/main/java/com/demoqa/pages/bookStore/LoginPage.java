package com.demoqa.pages.bookStore;

import com.demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "userName")
    WebElement userNameInput;
    @FindBy(id = "password")
    WebElement userPasswordInput;

    public LoginPage enterUserData(String userName, String password) {

        type(userNameInput,userName);
        type(userPasswordInput,password);

        return this;
    }
}
