package com.automation.pages;

import com.automation.data.BaseData;
import com.automation.elements.Static;
import com.automation.utility.ConfigReader;
import com.automation.utility.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static com.automation.utility.Screenshots.takeScreenshot;
import static com.automation.utility.Sleep.sleep;
import static com.automation.utility.TimeCapture.screenshotTime;

public abstract class BasePage {

    protected WebDriver driver;
    protected String pageTitle;
    private Static successMessage = new Static(By.xpath("//div[@class='row contact']/div[@class=\"col-sm-5\"][1]"));

    public BasePage() {
        this.driver = DriverManager.getInstance().getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,
                Integer.parseInt(ConfigReader.getProperty("webDriverWaitTime"))), this);
        logPageTitle();
    }

    public Static getSuccessMessage() {
        return successMessage;
    }

    private void logPageTitle() {
        pageTitle = driver.getTitle();
        sleep(3000);
        takeScreenshot(driver, screenshotTime());
        System.out.println("Navigated to '" + pageTitle + "' page.");
    }

    protected void verifySuccessMessage(String message) {
        getSuccessMessage().verify(message, "Success Message");
    }

    public abstract void fillout(BaseData bData);

    public abstract void verify(BaseData bData);
}
