package tests.positive;

import enums.Email;
import enums.Password;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.basetest.BaseUITest;

public class LoginTest extends BaseUITest {
    private static final String USER_EMAIL_TO_CHECK_FOR = "ipettkov@abv.bg";

    @Test
    @Tag("login")
    @DisplayName("Can login with valid credentials")
    public void canLoginWithValidCredentials() {
        app.loginPage.login(Email.VALID_EMAIL, Password.VALILD_PASSWORD);
        app.homePage.verifySuccessfulLogin(USER_EMAIL_TO_CHECK_FOR);
        app.homePage.logout();
    }
}
