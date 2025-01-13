package com.automation.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverManager {

    public static WebDriver driver;
    private static DriverManager driverManager;
    private static ThreadLocal<WebDriver> tDriver = new ThreadLocal<>();

    private DriverManager() {

    }

    public static DriverManager getInstance() {
        if (driverManager == null) {
            synchronized (DriverManager.class) {
                driverManager = new DriverManager();
            }
        }
        return driverManager;
    }

    public static String getExecFolderPath() {
        String os = System.getProperty("os.name");
        String exeOs;
        if (os.toLowerCase().contains("mac"))
            exeOs = "mac";
        else
            exeOs = "win";
        exeOs = "_" + exeOs + "_" + ConfigReader.getProperty("driverVersion") + ".exe";
        return GlobalVariable.basePath + ConfigReader.getProperty("execPath") + ConfigReader.getProperty("webDriver") + "/" + ConfigReader.getProperty("webDriver") + exeOs;
    }

    public static void setDriverProp() {
        System.setProperty("webdriver.chrome.driver", getExecFolderPath());
        ChromeOptions option = new ChromeOptions();
        driver = new ChromeDriver(option);
        DriverManager.getInstance().setDriver(driver);
        driver.get(ConfigReader.getProperty("appUrl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("implicitlyWaitTime"))));
    }

    public synchronized WebDriver getDriver() {
        WebDriver driver = tDriver.get();
        if (driver == null) {
            throw new IllegalStateException("Driver should have not been null!!");
        }
        return driver;
    }

    public synchronized void setDriver(WebDriver driver) {
        tDriver.set(driver);
    }
}
