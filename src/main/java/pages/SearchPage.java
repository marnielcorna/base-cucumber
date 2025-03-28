package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Constants;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchInput;

    public SearchPage(WebDriver driver) {
        super(driver);
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
    }
    public void searchText(String text) {
        searchInput.isDisplayed();
        searchInput.clear();
        searchInput.sendKeys(text);
    }



    public void selectCheapestItemByPriceBetween (int lower, int higher){
        List<WebElement> results = driver.findElements(By.xpath("//div[@role='listitem']//span[@data-csa-c-posx]"));
        WebElement cheapestItem = null;
        int minPrice = Integer.MAX_VALUE;

        for (WebElement item : results){
            WebElement priceItem = item.findElement(By.xpath("//span[@class='a-price']/span"));
            String priceText = priceItem.getText().replaceAll("[^0-9.]", "").trim();
            System.out.println("THIS IS THE PRICE TEXT ########### " + priceText);
            try {
                if (!priceText.isEmpty()) {
                    int price = (int) Double.parseDouble(priceText);

                    if (price >= lower && price <= higher && price < minPrice){
                        System.out.println("MIN PRICE ##### " + minPrice);
                        minPrice = price;
                        cheapestItem = item;
                        System.out.println("ITEM ####### " + item);
                    }
                }

            } catch (Exception e){
                System.out.println();
            }
        }

    }
}
