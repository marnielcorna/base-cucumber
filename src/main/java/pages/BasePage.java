package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;

import java.time.Duration;


public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_TIME_OUT_SECONDS));
        PageFactory.initElements(driver, this);
    }

    public WebElement waitElementUntilVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitElementUntilPresent(WebElement element) {
        return wait.until(driver -> {
            try {
                element.isDisplayed();
                return element;
            } catch (Exception e) {
                return null;
            }
        });
    }

    public WebElement waitElementUntilClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForSeconds(int seconds) {
        wait.until(d -> false);
    }
}
