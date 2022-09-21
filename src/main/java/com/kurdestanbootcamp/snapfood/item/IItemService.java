package com.kurdestanbootcamp.snapfood.item;

import com.kurdestanbootcamp.snapfood.common.SearchCriteria;
import com.kurdestanbootcamp.snapfood.supplier.Supplier;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IItemService {

    Item save(Item item);
    Item update(Item item);
    void delete(Long id);
    Item getById(Long id);
    List<Item> getAll();

    List<Item> getAllBySupplierCategory(Long supplierCategoryId);

    Page<Item> paging(Integer page, Integer size);

    List<Item> search(List<SearchCriteria> searchCriteria);

    List<Item> getAllBySupplierCategory_Supplier(Long supplierId);



}
