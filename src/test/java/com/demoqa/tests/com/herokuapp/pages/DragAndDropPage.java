package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragAndDropPage {

    private WebDriver driver;

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
    }

    public DragAndDropPage dragAtoB() {
        driver.findElement(By.id("column-a"))
                .click();

        return this;
    }

    public DragAndDropPage moveAtoB() {
        org.openqa.selenium.interactions.Actions actions =
                new org.openqa.selenium.interactions.Actions(driver);

        actions.dragAndDrop(
                driver.findElement(By.id("column-a")),
                driver.findElement(By.id("column-b"))
        ).perform();

        return this;
    }

    public String getColumnAText() {
        return driver.findElement(By.id("column-a")).getText();
    }

    public String getColumnBText() {
        return driver.findElement(By.id("column-b")).getText();
    }
}
