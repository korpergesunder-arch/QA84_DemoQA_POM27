package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MultipleWindowsPage {

    private WebDriver driver;

    @FindBy(linkText = "Click Here")
    WebElement clickHere;

    public MultipleWindowsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MultipleWindowsPage clickHere() {
        clickHere.click();
        return this;
    }

    public MultipleWindowsPage switchToNewWindow() {
        String originalWindow = driver.getWindowHandle();

        for (String window : driver.getWindowHandles()) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        return this;
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
