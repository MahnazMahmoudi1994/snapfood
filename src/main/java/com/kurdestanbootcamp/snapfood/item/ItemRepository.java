package com.kurdestanbootcamp.snapfood.item;

import com.kurdestanbootcamp.snapfood.supplier.Supplier;
import com.kurdestanbootcamp.snapfood.supplier_category.SupplierCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends PagingAndSortingRepository<Item, Long>, JpaSpecificationExecutor<Item> {
    List<Item> findAllBySupplierCategory(SupplierCategory supplierCategory);

    Page<Item> findAll(Pageable pageable);

    List<Item> findAll(Specification<Item> specification);
    List<Item> findAllBySupplierCategory_Supplier(Supplier supplier);

}