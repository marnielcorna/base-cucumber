package stepdefinitions;

import driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import org.junit.Assert;
import utils.Constants;
import utils.UserManager;


public class LoginSteps {
    WebDriver driver = DriverManager.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("I am in the login page")
    public void iAmInTheLoginPage() {
//        Assert.assertTrue(loginPage.getLogo());
        System.out.println("Hello");
    }

    @When("I access the application with {string} credentials")
    public void iAccessTheApplicationWithCredentials(String role) {
        loginPage.enterUsername(UserManager.username(role));
        loginPage.clickButton(Constants.CONTINUE);
        loginPage.enterPassword(UserManager.password(role));
        loginPage.clickButton(Constants.SUBMIT);
    }

    @When("I wait some time")
    public void iWaitSomeTime() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
