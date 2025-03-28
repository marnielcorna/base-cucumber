package stepdefinitions;

import driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.CrossPage;
import pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import utils.Constants;
import utils.UserManager;


public class LoginSteps {
    WebDriver driver = DriverManager.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    CrossPage crossPage = new CrossPage(driver);

    @Given("I am in the login page")
    public void iAmInTheLoginPage() {
        Assertions.assertTrue(loginPage.loginPageIsDisplayed());
    }

    @When("I access the application with {string} credentials")
    public void iAccessTheApplicationWithCredentials(String role) {
        try {
            loginPage.enterUsername(UserManager.username(role));
            crossPage.clickButton(Constants.CONTINUE);
            loginPage.enterPassword(UserManager.password(role));
            crossPage.clickButton(Constants.SUBMIT);
        } catch (Exception e){
            Assertions.fail("Failed to access the application with ### " + role.toUpperCase() + " ### credentials: " + e);
        }
    }
}
