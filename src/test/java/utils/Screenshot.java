package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Screenshot {

    private static WebDriver driver = DriverFactory.getDriver();

    public static void screenshotAssertion(String testName) throws IOException {
        long timestampScreenshot = new Date().getTime();
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile2 = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile2,
                new File("src/test/resources/screenshot/" + testName + "/" + timestampScreenshot + ".png"));
    }
}
