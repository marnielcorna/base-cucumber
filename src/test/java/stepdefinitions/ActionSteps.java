package stepdefinitions;

import driver.DriverManager;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.CrossPage;
import pages.SearchPage;
import utils.Constants;

public class ActionSteps{
    WebDriver driver = DriverManager.getDriver();
    SearchPage searchPage = new SearchPage(driver);
    CrossPage crossPage = new CrossPage(driver);

    @When("I search for text {string}")
    public void iSearchForText(String text) {
        try {
            searchPage.searchTextSlowly(text, 100);
            crossPage.clickButton(Constants.SEARCH);
        } catch (Exception e){
            Assertions.fail("Failed to search for the text: " + text + " || ERROR: " + e);
        }
    }
}
