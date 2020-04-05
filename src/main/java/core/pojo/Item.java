package core.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    private String name;
    private int price_for_quantity;
    private String quantity_unit;
}
