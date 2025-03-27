package stepdefinitions;

import driver.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.Constants;
import utils.UserManager;

public class Hooks {
    private static WebDriver driver;

    @Before
    public void setup() {
        System.out.println("------- Launching Browser -------");
        driver = DriverManager.getDriver();
        String url = ConfigReader.getProperty(Constants.URL);
        driver.get(url);

        //To demonstrate it works only:
        System.out.println("Testing against URL: ---------> " + url);

    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Test Scenario failed: " + scenario.getName());
            //Implement screenshots later here.
        }
        System.out.println("------- Closing Browser -------");
        DriverManager.quitDriver();
    }
}
