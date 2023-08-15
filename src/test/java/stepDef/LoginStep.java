package stepDef;

import com.aventstack.extentreports.ExtentReports;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.LoginPage;
import utilities.ExcelHelper;

import java.io.IOException;
import java.time.Duration;

import static com.aventstack.extentreports.model.service.TestService.createTest;
import static org.openqa.selenium.remote.ErrorCodes.TIMEOUT;

public class LoginStep {
    public static WebDriver driver;

    @Before
    public static void before_all(){
        //ExtentReports.initReport();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().window().maximize();
    }
    @Given("User is on Luma Login page {string}")
    public void userIsOnLumaLoginPage(String url) {
        createTest(" Sign in");
        LoginPage.SignInBtn();
    }

    @When("the user enters their credentials")
    public void theUserEntersTheirCredentials() throws IOException {
       String email = ExcelHelper.getCellData(6, 2);
        String password = ExcelHelper.getCellData(6, 3);
        LoginPage.LogIn(email, password);
    }

    @And("clicks the {string} button")
    public void clicksTheButton(String arg0) {
    }

    @Then("the user should be logged in")
    public void theUserShouldBeLoggedIn() {
    }
}
