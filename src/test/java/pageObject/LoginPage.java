package pageObject;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reporting.ExtentReports;
import stepDef.LoginStep;

import java.io.IOException;
import java.time.Duration;

import static reporting.ExtentReports.getScreenshot;
import static reporting.ExtentReports.test;

public class LoginPage {
    public WebDriver driver= LoginStep.driver;
    static WebDriverWait wait = new WebDriverWait(LoginStep.driver, Duration.ofSeconds(10));


    public static void SignInBtn(){
        LoginStep.driver.findElement(By.xpath("(//a[contains(text(),'Sign In')])[1]")).click();

    }
    public static void LogIn(String Email, String password) throws IOException {

//       ExtentReport.createTest("User Login");

        test.info("the user enters their credentials");

        WebElement emailInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@id='email'])[1]")));
        emailInput.sendKeys(Email);

        WebElement passwordInput = LoginStep.driver.findElement(By.xpath("(//input[@id='pass'])[1]"));
        passwordInput.sendKeys(password);
        test.info("Value entered", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("Sign In")).build());



    }
    public static void clickLoginButton(){
        LoginStep.driver.findElement(By.xpath("(//span[contains(text(),'Sign In')])[1]")).click();

    }

    public static void goTo(){
        LoginStep.driver.findElement(By.xpath("(//img)[1]")).click();
    }


}

