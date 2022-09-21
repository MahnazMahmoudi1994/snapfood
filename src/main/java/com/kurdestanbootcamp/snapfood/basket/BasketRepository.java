package com.kurdestanbootcamp.snapfood.basket;

import com.kurdestanbootcamp.snapfood.address.Address;
import com.kurdestanbootcamp.snapfood.supplier.Supplier;
import com.kurdestanbootcamp.snapfood.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BasketRepository extends PagingAndSortingRepository<Basket, Long> {

    List<Basket> findAllByAddress(Address address);

    List<Basket> findAllBySupplier(Supplier supplier);

    List<Basket> findAllByAddress_User(User user);

    List<Basket> findAllByStatus(Boolean status);

    Page<Basket> findAll(Pageable pageable);


}