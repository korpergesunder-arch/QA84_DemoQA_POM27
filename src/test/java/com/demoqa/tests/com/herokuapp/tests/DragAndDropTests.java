package com.herokuapp.tests;

import com.demoqa.tests.core.TestBase;
import com.herokuapp.pages.DragAndDropPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DragAndDropTests extends TestBase {

    DragAndDropPage dragAndDropPage;

    @BeforeEach
    public void precondition() {
        dragAndDropPage = new DragAndDropPage(driver);
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
    }

    @Test
    public void dragAndDropTest() {

        dragAndDropPage.moveAtoB();

        assertEquals("B", dragAndDropPage.getColumnAText());
        assertEquals("A", dragAndDropPage.getColumnBText());
    }
}
