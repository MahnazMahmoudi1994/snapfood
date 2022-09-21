package com.kurdestanbootcamp.snapfood.address;

import com.kurdestanbootcamp.snapfood.common.exception.NotFoundException;
import com.kurdestanbootcamp.snapfood.user.IUserService;
import com.kurdestanbootcamp.snapfood.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressService implements IAddressService {

    private final AddressRepository repository;
    private final IUserService userService;


    @Override
    public Address save(Address address) {
        Long userId = address.getUser().getId();
        User user = userService.getById(userId);
        address.setUser(user);
        return repository.save(address);
    }

    @Override
    public Address update(Address address) {

        Address lastAddress = getById(address.getId());

        lastAddress.setLocation(address.getLocation());
        lastAddress.setAddress(address.getAddress());
        lastAddress.setDetails(address.getDetails());
        lastAddress.setPhoneNumber(address.getPhoneNumber());

        Long userId = address.getUser().getId();
        User user = userService.getById(userId);
        lastAddress.setUser(user);

        return repository.save(lastAddress);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    @Override
    public Address getById(Long id) {

        Optional<Address> optionalAddress = repository.findById(id);

        if (!optionalAddress.isPresent()){

            throw new NotFoundException("Address Not Found");
        }

        return optionalAddress.get();
    }

    @Override
    public List<Address> getAll() {

        return (List<Address>) repository.findAll();
    }

    @Override
    public List<Address> getAllByUser(Long userId) {
        User user = userService.getById(userId);
        return repository.findAllByUser(user);
    }
}
