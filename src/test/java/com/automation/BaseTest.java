package com.automation;

import com.automation.utility.Screenshots;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

import static com.automation.utility.DriverManager.driver;
import static com.automation.utility.DriverManager.setDriverProp;

public class BaseTest {

    @BeforeMethod
    public void browserSetup(Method m) {
        //initializing testDataMap object to read values from the Excel file
        String testCaseName = m.getName();
        Screenshots.testName(testCaseName);

        launchBrowser();
    }

    @AfterMethod
    public void browserTeardown() {
        closeBrowser();
    }

    private void launchBrowser() {
        setDriverProp();
    }

    public void closeBrowser() {
        driver.quit();
    }
}
