package com.demoqa.core;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    public static JavascriptExecutor js;
    public static SoftAssertions softly;
    public static Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
        softly = new SoftAssertions();
        actions = new Actions(driver);
    }

    public void scrollWithJS(int x, int y) {
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    //FOR example принудительный скролл при помощи JS не зависит от координат
//    public void scrollWithJS(WebElement element){
//        js.executeScript("arguments[0].scrollIntoView(true);", element);
//        //js.executeScript("window.scrollBy(" + x + "," + y+ ")");
//    }


    public void clickWithJS(WebElement element, int x, int y) {
        scrollWithJS(x, y);
        js.executeScript("arguments[0].click();", element);// решение со скроллом независимо от разрегения экрана

    }

    public void typeWithJS(WebElement element, String text, int x, int y) {
        scrollWithJS(x, y);
        type(element, text);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    public boolean isAlertPresent(int time) {
        Alert alert = getWait(time)
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            driver.switchTo().alert().accept();
            return true;
        }
    }

    public WebDriverWait getWait(int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time));
    }

    public boolean isContainsText(String text, WebElement element) {
        return element.getText().contains(text);
    }

    public boolean shouldHaveText(WebElement element, String text, int time) {
        return getWait(time).until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public boolean isContainsCssValue(String color, WebElement selectedCar, String value) {
        return selectedCar.getCssValue(value).contains(color);
    }

    public boolean isElementVisible(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            e.getMessage();
            return false;
        }
    }

    public String getValue(WebElement element, String value) {
        return element.getDomAttribute(value);
    }

    public void waitIsElementVisibility(WebElement element, int time) {
        getWait(time).until(ExpectedConditions.visibilityOf(element));
    }
    public void verifyLinks(String url){

        try {
            URL linkUrl = new URL(url);
            //create URL connection and get response code
            HttpURLConnection connection = (HttpURLConnection) linkUrl.openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();
            int statusCode = connection.getResponseCode();
            if (statusCode >=400){
                System.out.println(url + " --> " + connection.getResponseMessage() + " is a BROKEN links");
            }else {
                System.out.println(url + " --> " + connection.getResponseMessage());
            }
        } catch (Exception e) {
            System.out.println(url + " --> " + "ERROR occurred");
        }
    }
}


