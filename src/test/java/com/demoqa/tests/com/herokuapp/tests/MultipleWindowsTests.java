package com.herokuapp.tests;

import com.demoqa.tests.core.TestBase;
import com.herokuapp.pages.MultipleWindowsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleWindowsTests extends TestBase {

    MultipleWindowsPage multipleWindowsPage;

    @BeforeEach
    public void precondition() {
        multipleWindowsPage = new MultipleWindowsPage(driver);
        driver.get("https://the-internet.herokuapp.com/windows");
    }

    @Test
    public void checkNewWindowTitleTest() {

        multipleWindowsPage.clickHere();

        multipleWindowsPage.switchToNewWindow();

        assertEquals("New Window", multipleWindowsPage.getTitle());
    }
}
