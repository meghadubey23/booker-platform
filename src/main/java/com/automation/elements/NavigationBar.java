package com.automation.elements;

import org.openqa.selenium.By;

public class NavigationBar extends BaseElements {

    public NavigationBar() {
        super(By.xpath("//ul[@class='menu-items']"));
    }
}
