package stepdefinitions;

import driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import org.junit.Assert;
import utils.UserManager;


public class LoginSteps {
    WebDriver driver = DriverManager.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("I am in the login page")
    public void iAmInTheLoginPage() {
        Assert.assertTrue(loginPage.getLogo());
    }


    @When("I access the application with {string} credentials")
    public void iAccessTheApplicationWithCredentials(String role) {
        loginPage.enterUsername(UserManager.username(role));
        loginPage.enterPassword(UserManager.password(role));
        loginPage.clickSubmit();
    }
}
