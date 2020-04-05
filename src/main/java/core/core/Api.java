package core.core;

import core.api.BankAccountAPI;
import core.api.ItemAPI;
import core.api.base.RestClient;

public class Api {
    public BankAccountAPI bankAccountAPI;
    public ItemAPI itemAPI;

    public void startApi() {
        RestClient.setRestClient();
        initializeAPIs();
    }

    public void initializeAPIs() {
        bankAccountAPI = new BankAccountAPI();
                itemAPI = new ItemAPI();
    }
}
