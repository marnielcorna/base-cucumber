package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy (xpath = "//*[contains(text(),'username')]")
    private WebElement usernameInput;

    @FindBy (xpath = "//*[contains(text(),'password')]")
    private WebElement passwordInput;
    @FindBy (xpath = "//*[contains(text(),'submit')]")
    private WebElement submitInput;

    @FindBy (xpath ="//a/i[contains(@class,'a-icon-logo')]")
    private WebElement logoCompany;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean getLogo(){
        return logoCompany.isDisplayed();
    }
    public void enterUsername(String username){
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void clickSubmit(){
        submitInput.click();
    }
}
