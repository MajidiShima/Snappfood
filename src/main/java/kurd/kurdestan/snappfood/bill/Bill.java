package kurd.kurdestan.snappfood.bill;


import kurd.kurdestan.snappfood.basket.Basket;
import kurd.kurdestan.snappfood.common.BaseEntity;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tbl_bill")
@Data
@Audited
public class Bill extends BaseEntity {

    @Column(name = "totalPrice")
    private BigDecimal totalPrice;

    @OneToOne
    @JoinColumn(name = "basket_id")
    private Basket basket;



}
