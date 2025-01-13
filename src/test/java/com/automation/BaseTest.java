package com.automation;

import com.automation.utility.DriverManager;
import com.automation.utility.LoggerUtil;
import com.automation.utility.Screenshots;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

import static com.automation.listeners.TestNGReportListener.*;
import static com.automation.utility.DriverManager.setDriverProp;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void browserSetup() {
        launchBrowser();
        this.driver = DriverManager.getInstance().getDriver();

        if (getTest() == null) {
            // Handle the case where test was not created yet
            setTest(getExtent().createTest(getClass().getSimpleName()));
        }
        LoggerUtil.logStep(getTest(), "Start Browser");
    }

    @BeforeMethod
    public void setUp(Method m) {
        //initializing testDataMap object to read values from the Excel file
        Screenshots.testName(m.getName());
    }

    @AfterMethod
    public void teardown(Method m) {
        Screenshots.testName(m.getName());
    }

    @AfterClass
    public void browserTeardown() {
        closeBrowser();
    }

    private void launchBrowser() {
        setDriverProp();
    }

    public void closeBrowser() {
        driver.quit();
        LoggerUtil.logStep(getTest(), "Quit Browser");
    }
}
