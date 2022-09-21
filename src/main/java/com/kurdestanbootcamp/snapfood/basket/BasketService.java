package com.kurdestanbootcamp.snapfood.basket;

import com.kurdestanbootcamp.snapfood.address.Address;
import com.kurdestanbootcamp.snapfood.address.IAddressService;
import com.kurdestanbootcamp.snapfood.basket_item.BasketItem;
import com.kurdestanbootcamp.snapfood.basket_item.IBasketItemService;
import com.kurdestanbootcamp.snapfood.common.exception.ConflictException;
import com.kurdestanbootcamp.snapfood.common.exception.NotFoundException;
import com.kurdestanbootcamp.snapfood.supplier.ISupplierService;
import com.kurdestanbootcamp.snapfood.supplier.Supplier;
import com.kurdestanbootcamp.snapfood.supplier_category.SupplierCategory;
import com.kurdestanbootcamp.snapfood.user.IUserService;
import com.kurdestanbootcamp.snapfood.user.User;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BasketService implements IBasketService {

    private final BasketRepository repository;
    private final IAddressService addressService;
    private final ISupplierService supplierService;
    private final IUserService userService;


    @Override
    public Basket save(Basket basket) {

        Long addressId = basket.getAddress().getId();
        Long supplierId = basket.getSupplier().getId();

        List<Basket> baskets = getAll();
        for (Basket basket1:baskets){
            if ((basket1.getAddress().getId().equals(addressId)) &&
                    (basket1.getSupplier().getId().equals(supplierId))){
                throw new ConflictException("This Basket has already been registered");
            }
        }
        Address address = addressService.getById(addressId);
        Supplier supplier = supplierService.getById(supplierId);


        basket.setAddress(address);
        basket.setSupplier(supplier);
        return repository.save(basket);
    }

    @Override
    public Basket update(Basket basket) {
        Basket lastBasket = getById(basket.getId());
        Long addressId = basket.getAddress().getId();
        Long supplierId = basket.getSupplier().getId();
        List<Basket> baskets = getAll();
        for (Basket basket1:baskets){
            if ((basket1.getAddress().getId().equals(addressId)) &&
                    (basket1.getSupplier().getId().equals(supplierId))){
                if(basket1.getId() == basket.getId()){
                    continue;
                }
                throw new ConflictException("This Basket has already been registered");
            }
        }


        lastBasket.setPaidPrice(basket.getPaidPrice());
        lastBasket.setStatus(basket.getStatus());

        Address address = addressService.getById(addressId);
        Supplier supplier = supplierService.getById(supplierId);
        lastBasket.setAddress(address);
        lastBasket.setSupplier(supplier);
        return repository.save(lastBasket);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    @Override
    public Basket getById(Long id) {
        Optional<Basket> optionalBasket = repository.findById(id);

        if (!optionalBasket.isPresent()){

            throw new NotFoundException("Basket Not Found");
        }

        return optionalBasket.get();
    }

    @Override
    public List<Basket> getAll() {

        return (List<Basket>) repository.findAll();
    }

    @Override
    public List<Basket> getAllByAddress(Long addressId) {
        Address address = addressService.getById(addressId);
        return repository.findAllByAddress(address);
    }

    @Override
    public List<Basket> getAllBySupplier(Long supplierId) {
        Supplier supplier = supplierService.getById(supplierId);
        return repository.findAllBySupplier(supplier);
    }

    @Override
    public List<Basket> getAllByAddress_User(Long userId) {
        User user = userService.getById(userId);
        return repository.findAllByAddress_User(user);
    }

    @Override
    public List<Basket> getAllByStatus(Boolean status) {
       return repository.findAllByStatus(status);
    }

    @Override
    public Page<Basket> paging(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }


}
