package com.automation.elements;

import org.openqa.selenium.By;

public class Button extends BaseElements {

    public Button(By locator) {
        super(locator);
    }

    protected BaseElements getButton() {
        return this;
    }

    // Additional methods specific to button elements, if needed

}
