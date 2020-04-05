package core.api;

import core.api.base.RestClient;
import core.pojo.Item;
import io.restassured.response.Response;

public class ItemAPI extends RestClient {
    private final static String RESOURCE_ITEM = "/item";
    private final static String RESOURCE_ITEMS = "/items";

    public void createItem(String name, int price_for_quantity, String quantity_unit) {
        Item item = new Item(name, price_for_quantity, quantity_unit);
        post(RESOURCE_ITEM, gson.toJson(item));
    }

    public void deleteItem(String itemId) {
        delete(RESOURCE_ITEM, itemId);
    }

    private Response getAllItems() {
        return get(RESOURCE_ITEMS, "");
    }
}
