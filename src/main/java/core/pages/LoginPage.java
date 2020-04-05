package core.pages;

import core.pages.base.BaseUIPage;
import enums.Email;
import enums.Password;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage extends BaseUIPage {
    private final static By EMAIL_FIELD = By.id("loginusername");
    private final static By PASSWORD_FIELD = By.id("loginpassword");
    private final static By LOGIN_BUTTON = By.id("loginsubmit");
    private final static By ERROR_MSG = By.id("error");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getErrorMsg() {
        return getText(ERROR_MSG);
    }

    public void login(Email email, Password password) {
        typeText(EMAIL_FIELD, email.getEmail());
        typeText(PASSWORD_FIELD, password.getPassword());
        click(LOGIN_BUTTON);
    }

    public void verifyErrorMessage(String errorMsg) {
        assertEquals(errorMsg, getErrorMsg());
    }
}
