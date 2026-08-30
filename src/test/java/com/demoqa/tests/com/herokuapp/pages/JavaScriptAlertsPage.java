package com.herokuapp.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptAlertsPage {

    private WebDriver driver;

    @FindBy(xpath = "//button[text()='Click for JS Alert']")
    WebElement jsAlertButton;

    @FindBy(xpath = "//button[text()='Click for JS Confirm']")
    WebElement jsConfirmButton;

    @FindBy(xpath = "//button[text()='Click for JS Prompt']")
    WebElement jsPromptButton;

    @FindBy(id = "result")
    WebElement result;

    public JavaScriptAlertsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public JavaScriptAlertsPage clickJsAlert() {
        jsAlertButton.click();
        return this;
    }

    public JavaScriptAlertsPage acceptAlert() {
        driver.switchTo().alert().accept();
        return this;
    }

    public JavaScriptAlertsPage clickJsConfirm() {
        jsConfirmButton.click();
        return this;
    }

    public JavaScriptAlertsPage dismissAlert() {
        driver.switchTo().alert().dismiss();
        return this;
    }

    public JavaScriptAlertsPage clickJsPrompt() {
        jsPromptButton.click();
        return this;
    }

    public JavaScriptAlertsPage enterText(String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
        return this;
    }

    public String getResult() {
        return result.getText();
    }
}