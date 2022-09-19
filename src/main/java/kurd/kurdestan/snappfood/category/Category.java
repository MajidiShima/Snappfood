package kurd.kurdestan.snappfood.category;

import kurd.kurdestan.snappfood.common.BaseEntity;
import kurd.kurdestan.snappfood.supplier.Supplier;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name="tbl_category")
@Data
@Audited
public class Category extends BaseEntity {

    @NotNull
    @Column(name="title")
    private  String title;

    @NotNull
    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private TypeOfCategory typeOfCategory;

    @Column(name="image")
    private String image;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
    private List<Supplier> suppliers;



}
