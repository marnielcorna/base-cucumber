package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigReader;
import utils.Constants;

public class DriverManager {
    private static WebDriver driver;

    private DriverManager(){

    }

    public static WebDriver getDriver(){
        if (driver == null) {
            String browser = ConfigReader.getProperty(Constants.BROWSER);
            switch (browser.toLowerCase()) {
                case Constants.FIREFOX:
                    driver = new FirefoxDriver();
                    break;
                case Constants.CHROME:
                    driver = new ChromeDriver();
                    break;
                case Constants.EDGE:
                    driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
