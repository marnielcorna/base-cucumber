package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Constants;

public class CrossPage extends BasePage {

    @FindBy (xpath = "//*[@id='continue']")
    private WebElement continueBtn;
    @FindBy (xpath = "//*[@id='signInSubmit']")
    private WebElement submitBtn;
    @FindBy (xpath = "//input[@id='nav-search-submit-button']")
    private WebElement searchButton;

    public CrossPage(WebDriver driver) {
        super(driver);
    }

    public void clickButton(String button){
        switch (button) {
            case "continue":
                continueBtn.click();
                break;
            case "submit":
                submitBtn.click();
                break;
            case "search":
                searchButton.click();
            default:
                break;
        }
    }
}
