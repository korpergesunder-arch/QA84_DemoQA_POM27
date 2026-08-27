package com.demoqa.pages.elements;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends BasePage {
    public TextBoxPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "currentAddress")
    WebElement currentAddress;
    public TextBoxPage copyPast(String address) {
        typeWithJS(currentAddress,address,0,400);
        //type current address text
        actions.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).perform();
        //copy current address text
        actions.keyDown(Keys.COMMAND).sendKeys("c").keyUp(Keys.COMMAND).perform();
        //press TAB to switch focus to permanent address
        actions.sendKeys(Keys.TAB).perform();
        //past current address text to  permanent address
        actions.keyDown(Keys.COMMAND).sendKeys("v").keyUp(Keys.COMMAND).perform();

        return this;
    }
        @FindBy(id = "submit")
        WebElement submit;
    public TextBoxPage clickOnSubmitButton() {
        clickWithJS(submit,0,200);
        return this;
    }
    @FindBy(css = ".border #currentAddress")
    WebElement currentAddressResult;
    @FindBy(css = ".border #permanentAddress")
    WebElement permanentAddressResult;
    public TextBoxPage verifyAddress() {
        String[] current = currentAddressResult.getText().split(":");
        String[] permanent = permanentAddressResult.getText().split(":");
        Assertions.assertEquals(current[1],permanent[1]);
        return this;
    }
    @FindBy(id ="userName")
    WebElement userName;
    @FindBy(id = "userEmail")
    WebElement userEmail;
    @FindBy(id ="permanentAddress")
    WebElement permanentAddress;

    public TextBoxPage enterPersonalData(String name, String email, String address) {
        typeWithJS(userName,name,0,300);
        typeWithJS(userEmail,email,0,300);
        typeWithJS(currentAddress,address,0,300);
        typeWithJS(permanentAddress,address,0,300);
        return this;
    }

    public TextBoxPage enterPersonalDataWithJS(String name, String email) {
        js.executeScript("document.getElementById('userName').value='" + name + "';");
        js.executeScript("document.getElementById('userEmail').value='" + email + "';");
        return this;
    }

    public TextBoxPage clickOnSubmitWithJS() {
        js.executeScript("document.querySelector('#submit').click();");
        js.executeScript("document.querySelector('#submit').style.backgroundColor='red';");
        return this;
    }

    public TextBoxPage getInnerText() {
        String innerText = js.executeScript("return document.documentElement.innerText;").toString();
        System.out.println(innerText);
        return this;
    }

    public TextBoxPage verifyUrl() {
        String url = js.executeScript("return document.URL").toString();
        System.out.println("URL = " + url);
        return this;
    }

    public TextBoxPage refreshWithJS() {
        js.executeScript("history.go(0);");
        return this;
    }

    public TextBoxPage navigateWithJS(String url) {
        js.executeScript("window.location='"+url+"';");
        return this;
    }

    public TextBoxPage verifyFaveIconTitle() {
        String title = js.executeScript("return document.title;").toString();
        System.out.println(title);
        return this;
    }
}
