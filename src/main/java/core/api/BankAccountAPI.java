package core.api;

import core.api.base.RestClient;
import core.pojo.BankAccount;

public class BankAccountAPI extends RestClient {
    private final static String RESOURCE_PATH = "/settings/bankaccounts";

    public void createBankAccount(String bank_name, String bank_name_en, String bank_bic, String bank_iban, String currency) {
        BankAccount bankAccount = new BankAccount(bank_name, bank_name_en, bank_bic, bank_iban, currency);
        post(RESOURCE_PATH, gson.toJson(bankAccount));
    }
}
