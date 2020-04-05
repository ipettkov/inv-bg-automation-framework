package tests.basetest;

import core.core.Api;
import org.junit.jupiter.api.BeforeEach;

public class BaseAPITest {
    protected Api api;

    @BeforeEach
    public void beforeEach() {
        api = new Api();
        api.startApi();
    }
}
