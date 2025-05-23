import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    protected WebElement waitAndReturnElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitAndClick(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        } catch (Exception e) {
            System.out.println("Failed to wait and click element: " + locator + " - " + e.getMessage());
            e.printStackTrace();
        }
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void hoverOverElement(By locator) {
        WebElement element = waitAndReturnElement(locator);
        new org.openqa.selenium.interactions.Actions(driver).moveToElement(element).perform();
    }

    public void setCookie(String name, String value) {
        Cookie cookie = new Cookie(name, value);
        driver.manage().addCookie(cookie);
    }

    public String getBodyText() {
        WebElement bodyElement = this.waitAndReturnElement(By.tagName("body"));
        return bodyElement.getText();
    }


    public void waitForFixedTime(int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds + 1);
        wait.until(new ExpectedCondition<Boolean>() {
            private long endTime = System.currentTimeMillis() + seconds * 1000;

            @Override
            public Boolean apply(WebDriver driver) {
                return System.currentTimeMillis() >= endTime;
            }
        });
    }

    public void goToUrl(String url) {
        driver.get(url);
    }

    public void goBack() {
        driver.navigate().back();
    }
}
