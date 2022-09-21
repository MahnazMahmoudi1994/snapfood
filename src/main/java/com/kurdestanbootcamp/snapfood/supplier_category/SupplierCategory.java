package com.kurdestanbootcamp.snapfood.supplier_category;

import com.kurdestanbootcamp.snapfood.category.Category;
import com.kurdestanbootcamp.snapfood.common.BaseEntity;
import com.kurdestanbootcamp.snapfood.item.Item;
import com.kurdestanbootcamp.snapfood.supplier.Supplier;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_supplier_category", uniqueConstraints = {@UniqueConstraint(columnNames = {"supplier_id", "title"})})
@Data
@Audited
public class SupplierCategory extends BaseEntity {

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "logo")
    private String logo;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "supplierCategory",cascade = CascadeType.ALL)
    private List<Item> items;


}
