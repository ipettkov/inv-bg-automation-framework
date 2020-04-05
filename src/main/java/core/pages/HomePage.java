package core.pages;

import core.pages.base.BaseUIPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.*;

public class HomePage extends BaseUIPage {
    private final static By HEADER_PANEL = By.cssSelector("div.userpanel-header");
    private By LOGOUT_LINK = By.cssSelector("a.selenium-button-logout.button-logout");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void logout() {
        click(HEADER_PANEL);
        click(LOGOUT_LINK);
    }

    public void verifySuccessfulLogin(String userEmail) {
        assertEquals(userEmail, getText(HEADER_PANEL));
    }
}
