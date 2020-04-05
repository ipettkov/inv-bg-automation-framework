package core.api;

import core.api.base.RestClient;
import core.pojo.Item;
import io.restassured.response.Response;
import static org.junit.jupiter.api.Assertions.*;

public class ItemAPI extends RestClient {
    private final static String RESOURCE_ITEM = "/item";
    private final static String RESOURCE_ITEMS = "/items";
    private final static int OK_STATUS_CODE = 200;

    public void createItem(String name, int price_for_quantity, String quantity_unit) {
        Item item = new Item(name, price_for_quantity, quantity_unit);
        post(RESOURCE_ITEM, gson.toJson(item));
    }

    public void deleteItemAndVerify(String itemId) {
        Response response = delete(RESOURCE_ITEM, itemId);
        int statusCode = response.getStatusCode();
        assertEquals(OK_STATUS_CODE, statusCode);
        System.out.println("Delete status code: " + statusCode);
    }

    private Response getAllItems() {
        return get(RESOURCE_ITEMS, "");
    }
}
