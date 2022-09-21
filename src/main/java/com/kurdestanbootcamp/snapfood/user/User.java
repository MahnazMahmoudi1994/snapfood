package com.kurdestanbootcamp.snapfood.user;

import com.kurdestanbootcamp.snapfood.address.Address;
import com.kurdestanbootcamp.snapfood.common.BaseEntity;
import com.kurdestanbootcamp.snapfood.supplier.Supplier;
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
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "phone_number")
    private String phoneNumber;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL)
    private List<Address> addresses;


}