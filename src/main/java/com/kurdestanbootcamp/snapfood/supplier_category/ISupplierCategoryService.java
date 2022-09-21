package com.kurdestanbootcamp.snapfood.supplier_category;

import com.kurdestanbootcamp.snapfood.supplier.Supplier;

import java.util.List;

public interface ISupplierCategoryService {

    SupplierCategory save(SupplierCategory supplierCategory);
    SupplierCategory update(SupplierCategory supplierCategory);
    void delete(Long id);
    SupplierCategory getById(Long id);
    List<SupplierCategory> getAll();

    List<SupplierCategory> getAllBySupplier(Long supplierId);



}
