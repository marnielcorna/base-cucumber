package stepdefinitions;

import driver.DriverManager;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.CrossPage;
import utils.Constants;

public class ActionSteps {
    WebDriver driver = DriverManager.getDriver();
    CrossPage crossPage = new CrossPage(driver);

    @When("I search for text {string}")
    public void iSearchForText(String text) {
        try {
            crossPage.searchTextSlowly(text, 100);
        } catch (Exception e){
            Assertions.fail("Failed to search for the text: " + text + " || ERROR: " + e);
        }
    }
}
