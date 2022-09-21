package com.kurdestanbootcamp.snapfood.address;

import com.kurdestanbootcamp.snapfood.basket.Basket;
import com.kurdestanbootcamp.snapfood.category.Category;
import com.kurdestanbootcamp.snapfood.common.BaseEntity;
import com.kurdestanbootcamp.snapfood.supplier_category.SupplierCategory;
import com.kurdestanbootcamp.snapfood.user.User;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
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
    @Column(name = "location")
    private Point<G2D> location;

    @NotNull
    @Column(name = "address")
    private String address;

    @Column(name = "details")
    private String details;

    @NotNull
    @Column(name = "phone_number")
    private String phoneNumber;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "address",cascade = CascadeType.ALL)
    private List<Basket> baskets;



}