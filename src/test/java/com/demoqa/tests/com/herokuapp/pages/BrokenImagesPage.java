package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BrokenImagesPage {

    private WebDriver driver;

    public BrokenImagesPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getAllImages() {
        return driver.findElements(By.cssSelector(".example img"));
    }

    public int getImagesCount() {
        return getAllImages().size();
    }

    public boolean isImageBroken(WebElement image) {
        return image.getAttribute("naturalWidth").equals("0");
    }

    public int getBrokenImagesCount() {

        int brokenImages = 0;

        for (WebElement image : getAllImages()) {
            if (isImageBroken(image)) {
                brokenImages++;
            }
        }

        return brokenImages;
    }
}
