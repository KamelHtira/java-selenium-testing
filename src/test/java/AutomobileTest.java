import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AutomobileTest {
    private WebDriver driver;

    @Before
    public void setup() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
    }

    @Test
    public void testLoginAndSearchCars() {
        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("kamel4htira@gmail.com", "kamel4htira@gmail.com");

        // Step 2: Go to 'Prix du neuf' and search cars
        PrixDuNeufPage carPage = new PrixDuNeufPage(driver);
        carPage.goToPrixDuNeuf();

        carPage.selectRandomBrand();
        carPage.goToPrixDuNeuf(); // reuse URL instead of relying on browser history
        carPage.selectSpecificCar("Volkswagen", "Golf 8");

//        Step 4: Logout
        MonEspacePage monEspacePage = new MonEspacePage(driver);
        Boolean logoutSuccess = monEspacePage.logout();

        Assert.assertTrue("Should be on login page after logout", logoutSuccess);
    }

@Test
public void testFilterCarTypesAndManualGear() {
    OccasionPage occasionPage = new OccasionPage(this.driver);
    occasionPage.filterCarTypesAndManualGear();

    Assert.assertTrue(occasionPage.getPageTitle().contains("Offre"));
}

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
