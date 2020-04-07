package tests.basetest;

import core.core.Api;
import core.core.App;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseUITest extends BaseAPITest {
    protected Api api;
    protected App app;

    private final static String HOMEPAGE_URL = "https://ivan-ltd.inv.bg/login";
    private final static String BROWSER = "chrome";


    @BeforeEach
    public void beforeEach() {
        api = new Api();
        app = new App();

        api.startApi();
        app.startBrowser(BROWSER, HOMEPAGE_URL);
    }

    @AfterEach
    public void afterEach() {
        app.quit();
    }
}

