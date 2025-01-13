package com.automation.listeners;

import com.automation.utility.LoggerUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGReportListener implements ITestListener {
    private static ExtentReports extent;
    private static ExtentTest test;
    private static ITestResult tcResult;

    public static ITestResult getTcResult() {
        return tcResult;
    }

    public static ExtentTest getTest() {
        return test;
    }

    public static void setTest(ExtentTest test) {
        TestNGReportListener.test = test;
    }

    public synchronized static ExtentReports getExtent() {
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
        return extent;
    }

    @Override
    public void onStart(ITestContext context) {
        // Initialize ExtentReports
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        getExtent().attachReporter(sparkReporter);
        getExtent().setSystemInfo("Environment", "QA");
        getExtent().setSystemInfo("Tester", "Megha Dubey");
    }

    @Override
    public void onTestStart(ITestResult result) {
        tcResult = result;
        // Create a new test in the report
        setTest(getExtent().createTest(result.getMethod().getMethodName()));
        LoggerUtil.logStep(getTest(), String.format("Start %s execution", result.getMethod().getMethodName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        getTest().pass("Test Passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        getTest().fail("Test Failed: " + result.getMethod().getMethodName());
        getTest().fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        getTest().skip("Test Skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        LoggerUtil.logStep(getTest(), String.format("Stop %s execution", getTcResult().getMethod().getMethodName()));
        // Flush the report
        getExtent().flush();
    }
}
