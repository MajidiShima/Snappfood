package kurd.kurdestan.snappfood.address;


import kurd.kurdestan.snappfood.basket.Basket;
import kurd.kurdestan.snappfood.common.BaseEntity;
import kurd.kurdestan.snappfood.user.User;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_address")
@Data
@Audited
public class Address extends BaseEntity {

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Basket> basketList;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

}
