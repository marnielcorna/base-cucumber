package pages.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class SearchPage extends BasePage {

    @FindBy (xpath = "//*[contains(text(),'username')]")
    private WebElement usernameInput;

    @FindBy (xpath = "//*[contains(text(),'password')]")
    private WebElement passwordInput;
    @FindBy (xpath = "//*[contains(text(),'submit')]")
    private WebElement submitInput;

    public SearchPage (WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username){
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password){
        usernameInput.sendKeys(password);
    }

    public void clickSubmit(){
        submitInput.click();
    }
}
