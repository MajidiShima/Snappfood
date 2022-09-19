package kurd.kurdestan.snappfood.supplier;

import kurd.kurdestan.snappfood.basket.Basket;
import kurd.kurdestan.snappfood.category.Category;
import kurd.kurdestan.snappfood.common.BaseEntity;
import kurd.kurdestan.snappfood.supplier_category.SupplierCategory;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="tbl_supplier")
@Data
@Audited
public class Supplier extends BaseEntity {

    @NotNull
    @Column(name="name")
    private String name;

    @NotNull
    @Column(name="location")
    private Point<G2D> location;

    @NotNull
    @Column(name = "address")
    private String address;


    @NotNull
    @Column(name = "image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "supplier",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Basket> baskets;

    @OneToMany(mappedBy = "supplier",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<SupplierCategory> supplierCategories;

}
