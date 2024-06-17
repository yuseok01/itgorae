package hello.itemservice.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Data //data 롬복
@Getter @Setter
public class Item {

    private Long id;
    private String itemName;
    private Integer price; //널가능
    private Integer quantity; //널가능

    public Item() {
    }

    //id를 제외한 생성자
    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
