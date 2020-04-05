package core.pages;

import core.pages.base.BaseUIPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BaseUIPage {
    private final static By SETTINGS_MENU = By.cssSelector("a.selenium-settings-menu");
    private final static By ITEMS_MENU = By.cssSelector("div#tabs_objects");

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public void clickSettingsMenu() {
        click(SETTINGS_MENU);
    }

    public void clickItemsMenu() {
        dissmissNewFeatureOKButt();
        waitForElement(ITEMS_MENU);
        click(ITEMS_MENU);
    }
}
