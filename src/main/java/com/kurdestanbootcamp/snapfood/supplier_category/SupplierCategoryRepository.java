package com.kurdestanbootcamp.snapfood.supplier_category;

import com.kurdestanbootcamp.snapfood.supplier.Supplier;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SupplierCategoryRepository extends PagingAndSortingRepository<SupplierCategory, Long> {
    List<SupplierCategory> findAllBySupplier(Supplier supplier);

}