package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {

    private WebDriver driver;

    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public NestedFramesPage switchToLeftFrame() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        return this;
    }

    public NestedFramesPage switchToMiddleFrame() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        return this;
    }

    public NestedFramesPage switchToRightFrame() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-right");
        return this;
    }

    public NestedFramesPage switchToBottomFrame() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        return this;
    }

    public String getFrameText() {
        return driver.findElement(By.tagName("body")).getText();
    }
}