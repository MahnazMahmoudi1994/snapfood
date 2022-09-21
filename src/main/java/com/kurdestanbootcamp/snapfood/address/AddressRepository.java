package com.kurdestanbootcamp.snapfood.address;


import com.kurdestanbootcamp.snapfood.user.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {

List<Address> findAllByUser(User user);

}