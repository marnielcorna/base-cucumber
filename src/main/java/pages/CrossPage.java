package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Constants;

public class CrossPage extends BasePage {
    @FindBy (xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchInput;
    @FindBy (xpath = "//*[@id='continue']")
    private WebElement continueBtn;
    @FindBy (xpath = "//*[@id='signInSubmit']")
    private WebElement submitBtn;
    @FindBy (xpath = "//input[@id='nav-search-submit-button']")
    private WebElement searchButton;

    public CrossPage(WebDriver driver) {
        super(driver);
    }

    public void searchText(String text) {
        searchInput.isDisplayed();
        searchInput.clear();
        searchInput.sendKeys(text);
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

    public void searchTextSlowly(String text, int delayMillis) {
        waitElementUntilPresent(searchInput);
        searchInput.clear();
        for (char ch : text.toCharArray()) {
            searchInput.sendKeys(String.valueOf(ch));
            try {
                Thread.sleep(delayMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        clickButton(Constants.SEARCH);
    }
}
