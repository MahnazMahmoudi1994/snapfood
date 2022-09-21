package com.kurdestanbootcamp.snapfood.item;

import com.kurdestanbootcamp.snapfood.basket_item.BasketItem;
import com.kurdestanbootcamp.snapfood.common.BaseEntity;
import com.kurdestanbootcamp.snapfood.supplier.Supplier;
import com.kurdestanbootcamp.snapfood.supplier_category.SupplierCategory;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_item")
@Data
@Audited
public class Item extends BaseEntity {

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "price")
    private Double price;

    @Column(name = "image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "supplier_category_id")
    private SupplierCategory supplierCategory;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "item",cascade = CascadeType.ALL)
    private List<BasketItem> basketItems;

}