package com.herokuapp.tests;

import com.demoqa.tests.core.TestBase;
import com.herokuapp.pages.NestedFramesPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NestedFramesTests extends TestBase {

    NestedFramesPage nestedFramesPage;

    @BeforeEach
    public void precondition() {
        nestedFramesPage = new NestedFramesPage(driver);
        driver.get("https://the-internet.herokuapp.com/nested_frames");
    }

    @Test
    public void checkLeftFrameTest() {

        nestedFramesPage
                .switchToLeftFrame();

        assertEquals("LEFT", nestedFramesPage.getFrameText());
    }

    @Test
    public void checkMiddleFrameTest() {

        nestedFramesPage
                .switchToMiddleFrame();

        assertEquals("MIDDLE", nestedFramesPage.getFrameText());
    }

    @Test
    public void checkRightFrameTest() {

        nestedFramesPage
                .switchToRightFrame();

        assertEquals("RIGHT", nestedFramesPage.getFrameText());
    }

    @Test
    public void checkBottomFrameTest() {

        nestedFramesPage
                .switchToBottomFrame();

        assertEquals("BOTTOM", nestedFramesPage.getFrameText());
    }
}