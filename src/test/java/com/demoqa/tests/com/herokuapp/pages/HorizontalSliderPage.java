package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HorizontalSliderPage {

    private WebDriver driver;

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
    }

    public HorizontalSliderPage moveSlider() {

        WebElement slider = driver.findElement(
                By.cssSelector("input[type='range']")
        );

        Actions actions = new Actions(driver);

        actions.clickAndHold(slider)
                .moveByOffset(100, 0)
                .release()
                .perform();

        return this;
    }

    public String getSliderValue() {

        WebElement slider = driver.findElement(
                By.cssSelector("input[type='range']")
        );

        return slider.getAttribute("value");
    }
}