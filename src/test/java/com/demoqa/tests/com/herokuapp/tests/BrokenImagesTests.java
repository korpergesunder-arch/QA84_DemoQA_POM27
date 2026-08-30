package com.herokuapp.tests;

import com.demoqa.tests.core.TestBase;
import com.herokuapp.pages.BrokenImagesPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BrokenImagesTests extends TestBase {

    BrokenImagesPage brokenImagesPage;

    @BeforeEach
    public void precondition() {
        brokenImagesPage = new BrokenImagesPage(driver);
        driver.get("https://the-internet.herokuapp.com/broken_images");
    }

    @Test
    public void checkImagesCountTest() {

        int count = brokenImagesPage.getImagesCount();

        assertEquals(3, count);
    }

    @Test
    public void checkBrokenImagesTest() {

        int brokenImages = brokenImagesPage.getBrokenImagesCount();

        assertTrue(brokenImages > 0);
    }
}
