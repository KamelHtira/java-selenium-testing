import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MonEspacePage extends BasePage {
    private By monEspaceMenu = By.xpath("//a[contains(text(), 'Mon espace')]");
    private By logoutLink = By.xpath("//a[contains(@href, '/deconnexion')]");
    private By loginFormEmail = By.id("loginform-email");

    public MonEspacePage(WebDriver driver) {
        super(driver);
    }

    public Boolean logout() {
        try {
            waitAndReturnElement(monEspaceMenu).click();
            waitForFixedTime(10);
            waitAndClick(logoutLink);
            waitAndReturnElement(loginFormEmail);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}

