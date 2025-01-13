package com.automation.elements;

import com.automation.utility.AssertUtility;
import com.automation.utility.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public abstract class BaseElements {
    public WebElement element;
    private WebDriver driver;

    public BaseElements(By locator) {
        // Assuming driver is initialized elsewhere before creating BaseElements instances
        this.driver = DriverManager.getInstance().getDriver();
        this.element = driver.findElement(locator);
    }

    public BaseElements chainElement(By locator) {
        this.element = element.findElement(locator);
        return this;
    }

    public BaseElements click() {
        element.click();
        return this;
    }

    public BaseElements sendKeys(String text) {
        element.clear();
        element.sendKeys(text);
        return this;
    }

    public String getText() {
        return element.getText();
    }

    public String getLabel() {
        return element.getAttribute("aria-label");
    }

    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    public String getAttribute(String attributeName) {
        return element.getAttribute(attributeName);
    }

    // Add more common functions as needed

    public BaseElements selectDropdownOption(String option) {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(option);
        return this;
    }

    public void set(String text) {
        if (text != null) {
            sendKeys(text);
            System.out.println("Set value of " + getLabel() + " as:" + text);
        }
    }

    public void set(Boolean action) {
        if (action != null)
            if (action) {
                System.out.println("Click button :" + getText());
                click();
            }
    }

    public void verify(String text) {
        verify(text, getText());
    }

    public void verify(String text, String label) {
        AssertUtility.assertEquals(getText(), text, label);
    }

    public void verifyContains(String text, String label) {
        AssertUtility.assertContains(getText(), text, label);
    }
}
