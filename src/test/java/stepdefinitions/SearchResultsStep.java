package stepdefinitions;

import driver.DriverManager;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.SearchPage;

public class SearchResultsStep {
    WebDriver driver = DriverManager.getDriver();
    SearchPage searchPage = new SearchPage(driver);

    @Then("A list of perfumes in the market")
    public void ListOfReturnedProductsIsDisplayed(){
        System.out.println("DISPLAYED RESULTS");
    }

    @Then("Select cheapest perfume between {int} and {int} euros.")
    public void thePerfumeCostsLessThanEuros(int lowerPrice, int higherPrice) {
        searchPage.selectCheapestItemByPriceBetween(lowerPrice, higherPrice);
    }
}
