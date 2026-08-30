package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {

    private WebDriver driver;

    @FindBy(id = "dropdown")
    WebElement dropdown;

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public DropdownPage selectOption1() {
        Select select = new Select(dropdown);
        select.selectByVisibleText("Option 1");
        return this;
    }

    public DropdownPage selectOption2() {
        Select select = new Select(dropdown);
        select.selectByVisibleText("Option 2");
        return this;
    }

    public String getSelectedOption() {
        Select select = new Select(dropdown);
        return select.getFirstSelectedOption().getText();
    }
}
