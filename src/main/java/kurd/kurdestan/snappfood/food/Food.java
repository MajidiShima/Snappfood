package kurd.kurdestan.snappfood.food;


import kurd.kurdestan.snappfood.basket_item.BasketItem;
import kurd.kurdestan.snappfood.supplier_category.SupplierCategory;
import kurd.kurdestan.snappfood.common.BaseEntity;
import lombok.Data;
import org.hibernate.envers.Audited;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "tbl_food")
@Data
@Audited
public class Food extends BaseEntity {

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "image")
    private String image;

    @Column(name="description")
    private String description;


    @ManyToOne()
    @JoinColumn(name = "SupplierCategory_id")
    private SupplierCategory supplierCategory;

    @OneToMany(mappedBy = "food",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<BasketItem> basketItemList;

}
