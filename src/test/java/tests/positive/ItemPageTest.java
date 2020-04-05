package tests.positive;

import enums.Email;
import enums.Password;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.basetest.BaseUITest;

public class ItemPageTest extends BaseUITest {
    private final static String ITEM_NAME = "Helmet";
    private final static int PRICE_FOR_QUANTITY = 118;
    private final static double NEW_PRICE_FOR_QUANTITY = 120.50;
    private final static String QUANTITY_UNIT = "piece";
    private final static String NEW_ITEM_NAME = "Bike Helmet";
    private final static String SETTINGS = "settings";
    private final static String ITEMS_MENU = "items";

    @Test
    @Tag("items")
    @DisplayName("Can create item via API and delete it via UI")
    public void canCreateItemViaAPIandDelViaUI() {
        api.itemAPI.createItem(ITEM_NAME, PRICE_FOR_QUANTITY, QUANTITY_UNIT);
        app.loginPage.login(Email.VALID_EMAIL, Password.VALILD_PASSWORD);
        app.headerPage.click(SETTINGS);
        app.itemsPage.deleteItemByName(ITEM_NAME);
        app.itemsPage.verifyItemSuccessfulDeletion();
    }

    @Test
    @Tag("items")
    @DisplayName("Can create item via UI and delete it via API")
    public void createItemViaUIandDelViaAPI() {
        app.loginPage.login(Email.VALID_EMAIL, Password.VALILD_PASSWORD);
        app.headerPage.click(ITEMS_MENU);
        app.itemsPage.clickCreateNewItem();
        app.newItemPage.createItem(ITEM_NAME, PRICE_FOR_QUANTITY);
        app.newItemPage.verifySuccessfulCreation();
        app.headerPage.click(ITEMS_MENU);
        api.itemAPI.deleteItemAndVerify(app.itemsPage.getIdByItemName(ITEM_NAME));
    }

    @Test
    @Tag("items")
    @DisplayName("Can create item via API and update it via UI")
    public void createItemViaAPIandUpdateViaUI() {
        api.itemAPI.createItem(ITEM_NAME, PRICE_FOR_QUANTITY, QUANTITY_UNIT);
        app.loginPage.login(Email.VALID_EMAIL, Password.VALILD_PASSWORD);
        app.headerPage.click(ITEMS_MENU);
        app.itemsPage.editItemByName(ITEM_NAME);
        app.newItemPage.updateItem(NEW_ITEM_NAME, NEW_PRICE_FOR_QUANTITY);
        app.newItemPage.verifySuccessfulUpdate();
        app.headerPage.click(ITEMS_MENU);
        app.itemsPage.deleteItemByName(NEW_ITEM_NAME);
    }
}
