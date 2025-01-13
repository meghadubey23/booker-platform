package com.automation.utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshots {

    private static String test;
    private static Boolean folderExists;

    public static void takeScreenshot(WebDriver driver, String fileName) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);

        String folderPath = GlobalVariable.basePath + ConfigReader.getProperty("reportPath") + test;

        File folder = new File(folderPath);
        File destinationFile;

        try {
            if (folderExists)
                FileUtils.deleteDirectory(folder);
            folderExists = false;
            destinationFile = new File(folderPath + "/" + test + "-" + fileName);

            FileUtils.copyFile(screenshotFile, destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testName(String testName) {
        test = testName;
        folderExists = true;
    }
}
