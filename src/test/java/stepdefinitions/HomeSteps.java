package stepdefinitions;

import io.cucumber.java.en.When;

public class HomeSteps {
    @When("I search for text {string}")
    public void iSearchForTextCars(String text) {
        System.out.println(text);
    }
}
