package kurd.kurdestan.snappfood.user;



import kurd.kurdestan.snappfood.address.Address;
import kurd.kurdestan.snappfood.common.BaseEntity;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_user")
@Data
@Audited
public class User extends BaseEntity {

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name="lastname")
    private String lastName;

    @NotNull
    @Column(name = "phone" )
    private Long phone;

    @NotNull
    @Column(name = "passWord")
    private String passWord;

    @NotNull
    @Column(name = "image")
    private String image;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Address> addressList;

}
