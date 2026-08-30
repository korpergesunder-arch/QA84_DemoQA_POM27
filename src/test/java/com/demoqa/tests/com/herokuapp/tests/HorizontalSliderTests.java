package com.herokuapp.tests;

import com.demoqa.tests.core.TestBase;
import com.herokuapp.pages.HorizontalSliderPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class HorizontalSliderTests extends TestBase {

    HorizontalSliderPage horizontalSliderPage;

    @BeforeEach
    public void precondition() {
        horizontalSliderPage = new HorizontalSliderPage(driver);
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
    }

    @Test
    public void moveSliderTest() {

        String initialValue = horizontalSliderPage.getSliderValue();

        horizontalSliderPage.moveSlider();

        String finalValue = horizontalSliderPage.getSliderValue();

        assertNotEquals(initialValue, finalValue);
    }
}