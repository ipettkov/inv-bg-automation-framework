package tests.positive;

import enums.Email;
import enums.Password;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.basetest.BaseUITest;

public class BankAccountTest extends BaseUITest {
    private final static String BANK_NAME = "IvanBank";
    private final static String BANK_NAME_EN = "IvanBankEN";
    private final static String BANK_BIC = "31412";
    private final static String BANK_IBAN = "BI53947756728818";
    private final static String CURRENCY = "BGN";
    private final static String EXPECTED_ERROR_MSG = "Банковата сметка е изтрита успешно.";


    @Test
    @Tag("bank-account")
    @DisplayName("Can delete existing bank account")
    public void canDeleteExistingBankAccount() {
        api.bankAccountAPI.createBankAccount(BANK_NAME, BANK_NAME_EN, BANK_BIC, BANK_IBAN, CURRENCY);

        app.loginPage.login(Email.VALID_EMAIL, Password.VALILD_PASSWORD);
        app.headerPage.clickSettingsMenu();
        app.settingsMenuPage.clickBankAccountsLink();
        app.bankAccountPage.deleteBankAccount();
        app.bankAccountPage.verifyAccountDeleted(EXPECTED_ERROR_MSG);
    }
}
