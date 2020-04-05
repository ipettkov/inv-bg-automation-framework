package core.pages;

import core.pages.base.BaseUIPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountPage extends BaseUIPage {
    private static final By DELETE_BANK_ACCOUNT = By.cssSelector("a.bank-account--delete.selenium-bank-acc-delete");
    private static final By DELETE_CONFIRMATION_BUTTON = By.cssSelector("button.modal-confirm__ok-button.selenium-modal-ok-btn");

    public BankAccountPage(WebDriver driver) {
        super(driver);
    }

    public void deleteBankAccount() {
        click(DELETE_BANK_ACCOUNT);
        click(DELETE_CONFIRMATION_BUTTON);
    }

    public void verifyAccountDeleted(String expectedErrorMsg) {
        assertEquals(expectedErrorMsg, getText(BaseUIPage.SUCCESS_MESSAGE_LOCATOR));
    }
}
