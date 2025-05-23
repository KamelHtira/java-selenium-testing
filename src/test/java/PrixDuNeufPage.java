import org.openqa.selenium.*;

import java.util.List;
import java.util.Random;

public class PrixDuNeufPage extends BasePage {
    private final String prixDuNeufUrl = "https://www.automobile.tn/fr/neuf";

    public PrixDuNeufPage(WebDriver driver) {
        super(driver);
    }

    public void goToPrixDuNeuf() {
        goToUrl(prixDuNeufUrl);
    }

    public void selectRandomBrand() {
        List<WebElement> brands = driver.findElements(By.xpath("//div[contains(@class,'brands-list')]//a"));
        if (!brands.isEmpty()) {
            brands.get(new Random().nextInt(brands.size())).click();
        }
    }

    public void writeComment(String text) {
        By commentField = By.xpath("//div[@class='comment-reply']//div//p");
        WebElement commentElement = waitAndReturnElement(commentField);
        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", commentElement, text);
    }

    public void selectSpecificCar(String brand, String model) {
        // Select brand by matching alt attribute of img tag
        By brandLink = By.xpath("//div[contains(@class,'brands-list')]//a[.//img[contains(@alt, '" + brand + "')]]");
        waitAndReturnElement(brandLink).click();

        // Select model by text (unchanged)
        By modelLink = By.xpath("//a[.//picture//img[contains(@alt, '" + model + "')]]");
        waitAndReturnElement(modelLink).click();
    }


    public void hoverOverCar(String carModelName) {
        By carCard = By.xpath("//div[contains(@class,'card')]//h2[contains(text(),'" + carModelName + "')]");
        hoverOverElement(carCard);
    }
}
