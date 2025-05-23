import org.openqa.selenium.*;

public class LoginPage extends BasePage {
    private final String loginUrl = "https://www.automobile.tn/fr/mon-espace/connexion";

    private final By emailField = By.id("loginform-email"); // You may need to confirm this
    private final By passwordField = By.id("loginform-password"); // You may need to confirm this
    private final By loginButton = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get(loginUrl);
    }

    public void login(String username, String password) {
        waitAndReturnElement(emailField).sendKeys(username);
        waitAndReturnElement(passwordField).sendKeys(password);
        waitAndReturnElement(loginButton).click();
    }
}
