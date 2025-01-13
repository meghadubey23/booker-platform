package com.automation.utility;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {

    private static final Logger logger = LogManager.getLogger(LoggerUtil.class);

    // Static method to log info
    public static void logInfo(String message) {
        logger.info(message);
    }

    // Static method to log error
    public static void logError(String message) {
        logger.error(message);
    }

    // Static method to log warning
    public static void logWarn(String message) {
        logger.warn(message);
    }

    // Static method to log debug
    public static void logDebug(String message) {
        logger.debug(message);
    }

    // Method to log info steps to ExtentReports
    public static void logStep(ExtentTest test, String message) {
        logger.info(message); // Log to console
        test.log(Status.INFO, message); // Log to ExtentReport
    }

    // Method to log pass steps to ExtentReports
    public static void logPass(ExtentTest test, String message) {
        logger.info(message);
        test.log(Status.PASS, message);
    }

    // Method to log fail steps to ExtentReports
    public static void logFail(ExtentTest test, String message) {
        logger.error(message);
        test.log(Status.FAIL, message);
    }
}

