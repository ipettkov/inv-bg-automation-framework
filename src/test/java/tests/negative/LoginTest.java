package tests.negative;

import enums.Email;
import enums.Password;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.basetest.BaseUITest;

public class LoginTest extends BaseUITest {

    private final static String EXPECTED_ERROR_MSG = "Грешно потребителско име или парола. Моля, опитайте отново.";

    @Test
    @Tag("login")
    @DisplayName("Cant login with invalid credentials")
    public void CantLoginWithInvalidCreds() {
        app.loginPage.login(Email.INVALID_EMAIL, Password.VALILD_PASSWORD);
        app.loginPage.verifyErrorMessage(EXPECTED_ERROR_MSG);
    }
}
