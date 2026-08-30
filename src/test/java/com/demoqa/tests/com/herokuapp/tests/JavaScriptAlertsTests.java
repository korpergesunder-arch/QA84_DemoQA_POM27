package com.herokuapp.tests;

import com.demoqa.tests.core.TestBase;
import com.herokuapp.pages.JavaScriptAlertsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaScriptAlertsTests extends TestBase {

    JavaScriptAlertsPage alertsPage;

    @BeforeEach
    public void precondition() {
        alertsPage = new JavaScriptAlertsPage(driver);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void jsAlertTest() {
        alertsPage
                .clickJsAlert()
                .acceptAlert();

        assertEquals("You successfully clicked an alert", alertsPage.getResult());
    }

    @Test
    public void jsConfirmTest() {
        alertsPage
                .clickJsConfirm()
                .acceptAlert();

        assertEquals("You clicked: Ok", alertsPage.getResult());
    }

    @Test
    public void jsConfirmCancelTest() {
        alertsPage
                .clickJsConfirm()
                .dismissAlert();

        assertEquals("You clicked: Cancel", alertsPage.getResult());
    }

    @Test
    public void jsPromptTest() {
        alertsPage
                .clickJsPrompt()
                .enterText("Hello");

        assertEquals("You entered: Hello", alertsPage.getResult());
    }
}