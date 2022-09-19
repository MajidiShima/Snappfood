package kurd.kurdestan.snappfood.basket_item;


import kurd.kurdestan.snappfood.basket.Basket;
import kurd.kurdestan.snappfood.common.BaseEntity;
import kurd.kurdestan.snappfood.food.Food;
import kurd.kurdestan.snappfood.supplier.Supplier;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_BasketItem")
@Data
@Audited
public class BasketItem extends BaseEntity {


    @NotNull
    @Column(name = "count")
    private Integer count;


    @ManyToOne()
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToOne()
    @JoinColumn(name = "basket_id")
    private Basket basket;

    @ManyToOne()
    @JoinColumn(name = "food_id")
    private Food food;

}
