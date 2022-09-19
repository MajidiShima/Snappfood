package kurd.kurdestan.snappfood.basket;


import kurd.kurdestan.snappfood.address.Address;
import kurd.kurdestan.snappfood.basket_item.BasketItem;
import kurd.kurdestan.snappfood.bill.Bill;
import kurd.kurdestan.snappfood.common.BaseEntity;
import kurd.kurdestan.snappfood.supplier.Supplier;
import lombok.Data;
import org.hibernate.envers.Audited;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="tbl_basket")
@Data
@Audited
public class Basket extends BaseEntity {

    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Column(name="status")
    private Status status ;


    @NotNull
    @Column(name="paidPrice")
    private String paidPrice;


    @ManyToOne()
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @OneToMany(mappedBy = "basket",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<BasketItem> basketItemList;

    @OneToOne(mappedBy = "basket",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Bill bill;

    @ManyToOne()
    @JoinColumn(name = "address_id")
    private Address address;


}
