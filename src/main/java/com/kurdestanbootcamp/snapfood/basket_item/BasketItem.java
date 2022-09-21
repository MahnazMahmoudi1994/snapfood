package com.kurdestanbootcamp.snapfood.basket_item;

import com.kurdestanbootcamp.snapfood.basket.Basket;
import com.kurdestanbootcamp.snapfood.common.BaseEntity;
import com.kurdestanbootcamp.snapfood.item.Item;
import com.kurdestanbootcamp.snapfood.supplier.Supplier;
import com.kurdestanbootcamp.snapfood.supplier_category.SupplierCategory;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_basket_item",uniqueConstraints = {@UniqueConstraint(columnNames = {"item_id","basket_id"})})
@Data
@Audited
public class BasketItem extends BaseEntity {

    @NotNull
    @Column(name = "count")
    private Integer count;

    @ManyToOne
    @JoinColumn(name = "basket_id")
    private Basket basket;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
}