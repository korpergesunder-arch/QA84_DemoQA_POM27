package com.herokuapp.tests;

import com.demoqa.tests.core.TestBase;
import com.herokuapp.pages.DropdownPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DropdownTests extends TestBase {

    DropdownPage dropdownPage;

    @BeforeEach
    public void precondition() {
        dropdownPage = new DropdownPage(driver);
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void selectOption1Test() {

        dropdownPage.selectOption1();

        assertEquals("Option 1", dropdownPage.getSelectedOption());
    }

    @Test
    public void selectOption2Test() {

        dropdownPage.selectOption2();

        assertEquals("Option 2", dropdownPage.getSelectedOption());
    }
}
