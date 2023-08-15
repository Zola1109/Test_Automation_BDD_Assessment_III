package reporting;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import stepDef.LoginStep;


import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public  class ExtentReports  {
    public static ExtentReports extent;
    public static ExtentTest test;
    private static ExtentSparkReporter spark;
    static String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    static String FileReporter ="src/test/java/reporting/html/html_" +timeStamp +".html";
    static WebDriver driver = LoginStep.driver;

    @BeforeSuite
    public static void initReports() {
        extent = new ExtentReports();
        spark = new ExtentSparkReporter(FileReporter);
//        extent.attachReporter(spark);
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle(" Luma BDD Cucumber Report");
        spark.config().setReportName("Extent Reports");
        driver = LoginStep.driver;
    }

    public static ExtentTest createTest(String testcasename) {
        test = extent.createTest(testcasename);
        return test;
    }

    public static String getScreenshot(String testCaseName) throws IOException {
        File source = ((TakesScreenshot) LoginStep.driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String fileName = "image_" + testCaseName + "_" + timestamp + ".png";
        String path = System.getProperty("user.dir") + "src/test/java/reporting/Screenshots/" + fileName;
        FileUtils.copyFile(source, new File(path));
        return path;
    }

    @AfterStep
    public static void after_step(Scenario scenario){
        if (scenario.isFailed()) {
            ExtentReports.test.log(Status.FAIL, String.valueOf(scenario));
        }
    }
//
//    @AfterSuite
//    public static void flushReports() throws IOException {
//        extent.flush();
//        Desktop.getDesktop().browse(new File(FileReporter).toURI());
//    }
}