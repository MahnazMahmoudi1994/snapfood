package com.kurdestanbootcamp.snapfood.basket_item;

import com.kurdestanbootcamp.snapfood.address.Address;
import com.kurdestanbootcamp.snapfood.basket.Basket;
import com.kurdestanbootcamp.snapfood.basket.IBasketService;
import com.kurdestanbootcamp.snapfood.common.exception.ConflictException;
import com.kurdestanbootcamp.snapfood.common.exception.NotFoundException;
import com.kurdestanbootcamp.snapfood.item.IItemService;
import com.kurdestanbootcamp.snapfood.item.Item;
import com.kurdestanbootcamp.snapfood.supplier.Supplier;
import com.kurdestanbootcamp.snapfood.supplier_category.SupplierCategory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BasketItemService implements IBasketItemService {

    private final BasketItemRepository repository;
    private final IBasketService basketService;
    private final IItemService itemService;


    @Override
    public BasketItem save(BasketItem basketItem) {

        Long basketId = basketItem.getBasket().getId();
        Long itemId = basketItem.getItem().getId();

        List<BasketItem> basketItems = getAll();
        for (BasketItem basketItem1:basketItems){
            if ((basketItem1.getBasket().getId().equals(basketId)) &&
                    (basketItem1.getItem().getId().equals(itemId))){
                throw new ConflictException("This BasketItem has already been registered");
            }
        }

        Basket basket = basketService.getById(basketId);
        Item item = itemService.getById(itemId);
        basketItem.setBasket(basket);
        basketItem.setItem(item);

        return repository.save(basketItem);
    }

    @Override
    public BasketItem update(BasketItem basketItem) {

        BasketItem lastBasketItem= getById(basketItem.getId());
        Long basketId = basketItem.getBasket().getId();
        Long itemId = basketItem.getItem().getId();

        List<BasketItem> basketItems = getAll();
        for (BasketItem basketItem1:basketItems){
            if ((basketItem1.getBasket().getId().equals(basketId)) &&
                    (basketItem1.getItem().getId().equals(itemId))){
                if(basketItem1.getId() == basketItem.getId()){
                    continue;
                }
                throw new ConflictException("This BasketItem has already been registered");
            }
        }

        lastBasketItem.setCount(basketItem.getCount());


        Basket basket = basketService.getById(basketId);
        Item item = itemService.getById(itemId);
        lastBasketItem.setBasket(basket);
        lastBasketItem.setItem(item);
        return repository.save(lastBasketItem);
    }

    @Override
    public void delete(Long id) {

        getById(id);
        repository.deleteById(id);
    }

    @Override
    public BasketItem getById(Long id) {
        Optional<BasketItem> optionalBasketItem = repository.findById(id);

        if (!optionalBasketItem.isPresent()){

            throw new NotFoundException("BasketItem Not Found");
        }

        return optionalBasketItem.get();
    }

    @Override
    public List<BasketItem> getAll() {
        return (List<BasketItem>) repository.findAll();
    }

    @Override
    public List<BasketItem> getAllByBasket(Long basketId) {
        Basket basket = basketService.getById(basketId);
        return repository.findAllByBasket(basket);
    }

    @Override
    public List<BasketItem> getAllByItem(Long itemId) {
        Item item = itemService.getById(itemId);
        return repository.findAllByItem(item);
    }


 /*   public Double calculatePrice(Long basketId){
        List<BasketItem> basketItems =getAllByBasket(basketId);
        Double totalPrice = Double.valueOf(0);
        if (basketItems!=null) {
            for (BasketItem basketItem : basketItems) {
                totalPrice += Double.valueOf(basketItem.getCount()) * basketItem.getItem().getPrice();
            }
        }
        return totalPrice;
    }*/

}
