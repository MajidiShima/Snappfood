package kurd.kurdestan.snappfood.supplier_category;



import kurd.kurdestan.snappfood.common.BaseEntity;
import kurd.kurdestan.snappfood.food.Food;
import kurd.kurdestan.snappfood.supplier.Supplier;
import lombok.Data;
import org.hibernate.envers.Audited;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_SupplierCategory")
@Data
@Audited
public class SupplierCategory extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "image")
    private String image;

    @ManyToOne()
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @OneToMany(mappedBy = "supplierCategory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Food> foodList;


}
