package core.core;

import core.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class App {
    private WebDriver driver;
    public LoginPage loginPage;
    public HomePage homePage;
    public BankAccountPage bankAccountPage;
    public SettingsMenuPage settingsMenuPage;
    public HeaderPage headerPage;
    public ItemsPage itemsPage;
    public NewItemPage newItemPage;


    public void startBrowser(String chooseBrowser, String url) {
        switch (chooseBrowser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }

        configureBrowser();
        initializePages();
        goToPage(url);
    }

    public void quit() {
        driver.quit();
    }

    private void initializePages() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        bankAccountPage = new BankAccountPage(driver);
        settingsMenuPage = new SettingsMenuPage(driver);
        headerPage = new HeaderPage(driver);
        itemsPage = new ItemsPage(driver);
        newItemPage = new NewItemPage(driver);
    }

    private void configureBrowser() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private void goToPage(String url) {
        driver.navigate().to(url);
    }
}
