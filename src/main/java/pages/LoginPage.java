package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy (xpath = "//*[@id='ap_email']")
    private WebElement usernameInput;

    @FindBy (xpath = "//*[@id='ap_password']")
    private WebElement passwordInput;
    @FindBy (xpath = "//*[@id='continue']")
    private WebElement continueBtn;
    @FindBy (xpath = "//*[@id='signInSubmit']")
    private WebElement submitBtn;

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

    public void clickButton(String button){
        switch (button) {
            case "continue":
                continueBtn.click();
                break;
            case "submit":
                submitBtn.click();
                break;
            default:
                break;
        }
    }
}
