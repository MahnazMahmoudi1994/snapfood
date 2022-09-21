package com.kurdestanbootcamp.snapfood.basket;


import com.kurdestanbootcamp.snapfood.address.Address;
import com.kurdestanbootcamp.snapfood.basket_item.BasketItem;
import com.kurdestanbootcamp.snapfood.common.BaseEntity;
import com.kurdestanbootcamp.snapfood.supplier.Supplier;
import com.kurdestanbootcamp.snapfood.user.User;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_basket",uniqueConstraints = {@UniqueConstraint(columnNames = {"supplier_id","address_id"})})
@Data
@Audited
public class Basket extends BaseEntity {


    @Column(name = "paid_price")
    private Double paidPrice;

    @Column(name = "status")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "basket",cascade = CascadeType.ALL)
    private List<BasketItem> basketItems;

}
