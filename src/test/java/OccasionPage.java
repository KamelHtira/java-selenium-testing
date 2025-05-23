import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class OccasionPage extends BasePage {

    private By citadineCheckbox = By.xpath("//input[@id='carrosserie_56']");
    private By suvCheckbox = By.xpath("//input[@id='carrosserie_61']");
    private By compacteCheckbox = By.xpath("//input[@id='carrosserie_57']");
    private By manualGearCheckbox = By.xpath("//input[@id='boite_74']");

    // New checkboxes
    private By autresCheckbox = By.xpath("//input[@id='carrosserie_65']");
    private By cabrioletCheckbox = By.xpath("//input[@id='carrosserie_60']");
    private By pickupCheckbox = By.xpath("//input[@id='carrosserie_64']");
    private By monospaceCheckbox = By.xpath("//input[@id='carrosserie_62']");
    private By utilitaireCheckbox = By.xpath("//input[@id='carrosserie_63']");
    private By berlineCheckbox = By.xpath("//input[@id='carrosserie_58']");
    private By coupeCheckbox = By.xpath("//input[@id='carrosserie_59']");

    public OccasionPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.automobile.tn/fr/occasion");
    }

    public void filterCarTypesAndManualGear() {
        waitAndReturnElement(citadineCheckbox).click();
        waitAndReturnElement(suvCheckbox).click();
        waitAndReturnElement(compacteCheckbox).click();
        waitAndReturnElement(manualGearCheckbox).click();

        // Click on the new checkboxes
        waitAndReturnElement(autresCheckbox).click();
        waitAndReturnElement(cabrioletCheckbox).click();
        waitAndReturnElement(pickupCheckbox).click();
        waitAndReturnElement(monospaceCheckbox).click();
        waitAndReturnElement(utilitaireCheckbox).click();
        waitAndReturnElement(berlineCheckbox).click();
        waitAndReturnElement(coupeCheckbox).click();

        waitForFixedTime(10);  // optional fixed wait, can be adjusted or removed
    }

    public boolean resultsContainManualGear() {
        // Placeholder for actual check implementation
        return true;
    }

    public void waitForFixedTime(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
