package pages;


import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.plaf.synth.SynthOptionPaneUI;


public class LoginPage extends BasePage {

    @FindBy (xpath = "//*[@id='ap_email']")
    private WebElement usernameInput;

    @FindBy (xpath = "//*[@id='ap_password']")
    private WebElement passwordInput;

    @FindBy (xpath ="//h1[contains(text(),'Sign in')]")
    private WebElement title;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean loginPageIsDisplayed(){
        return title.isDisplayed();
    }
    public void enterUsername(String username){
        try{
            usernameInput.clear();
            usernameInput.sendKeys(username);
        } catch (Exception e){
            System.out.println("Unable to enter the username: " + e);
        }
    }

    public void enterPassword(String password){
        try{
            passwordInput.clear();
            passwordInput.sendKeys(password);
        } catch (Exception e){
            System.out.println("Unable to enter the password: " + e);
        }
    }
}
