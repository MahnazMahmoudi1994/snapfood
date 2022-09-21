package com.kurdestanbootcamp.snapfood.address;


import com.kurdestanbootcamp.snapfood.user.User;

import java.util.List;

public interface IAddressService {

    Address save(Address address);
    Address update(Address address);
    void delete(Long id);
    Address getById(Long id);
    List<Address> getAll();

    List<Address> getAllByUser(Long userId);


}
