package com.kurdestanbootcamp.snapfood.basket;

import com.kurdestanbootcamp.snapfood.address.Address;
import com.kurdestanbootcamp.snapfood.supplier.Supplier;
import com.kurdestanbootcamp.snapfood.user.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IBasketService {

    Basket save(Basket basket);
    Basket update(Basket basket);
    void delete(Long id);
    Basket getById(Long id);
    List<Basket> getAll();

    List<Basket> getAllByAddress(Long addressId);

    List<Basket> getAllBySupplier(Long supplierId);

    List<Basket> getAllByAddress_User(Long userId);

    List<Basket> getAllByStatus(Boolean status);

    Page<Basket> paging(Integer page, Integer size);



}
