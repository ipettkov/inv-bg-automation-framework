package core.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BankAccount {
    private String bank_name;
    private String bank_name_en;
    private String bank_bic;
    private String bank_iban;
    private String currency;
}
