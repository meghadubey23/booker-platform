package com.automation.elements;

import org.openqa.selenium.By;

public class Static extends BaseElements {

    public Static(By locator) {
        super(locator);
    }

    @Override
    public String getText() {
        return element.getText();
    }
}
