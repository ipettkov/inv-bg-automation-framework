package core.pages;

import core.pages.base.BaseUIPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsMenuPage extends BaseUIPage {
    private final static By BANK_ACCOUNTS = By.cssSelector("a.settingsMenuEntry.selenium-bank-accounts-settings");

    public SettingsMenuPage(WebDriver driver) {
        super(driver);
    }

    public void clickBankAccountsLink() {
        click(BANK_ACCOUNTS);
    }
}
