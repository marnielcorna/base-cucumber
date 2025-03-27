package stepdefinitions;

import driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import utils.Constants;
import utils.UserManager;


public class LoginSteps {
    WebDriver driver = DriverManager.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("I am in the login page")
    public void iAmInTheLoginPage() {
        Assertions.assertTrue(loginPage.loginPageIsDisplayed());
    }

    @When("I access the application with {string} credentials")
    public void iAccessTheApplicationWithCredentials(String role) {
        try {
            loginPage.enterUsername(UserManager.username(role));
            loginPage.clickButton(Constants.CONTINUE);
            loginPage.enterPassword(UserManager.password(role));
            loginPage.clickButton(Constants.SUBMIT);
        } catch (Exception e){
            Assertions.fail("Failed to access the application with role: " + role + " credentials: " + e);
        }
    }

    @When("I wait some time")
    public void iWaitSomeTime() throws InterruptedException {
            Thread.sleep(10000);
    }
}
