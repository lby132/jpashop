package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//SINGLE_TABLE 전략에는 자동으로 DTYPE이 생성되어서  @DiscriminatorColumn을 적지 않아도 된다.
//이유는 JOINED전략은 create Book를 하기 때문에 어디 테이블에 어떤 컬럼인지 알 수 있지만
//SINGLE_TABLE전략에서는 Book테이블의 author인지 아닌지 알수가 없기 때문에 무조건 DTYPE이 있어야해서 자동으로 넣어준다.
@DiscriminatorColumn
public abstract class Item extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
