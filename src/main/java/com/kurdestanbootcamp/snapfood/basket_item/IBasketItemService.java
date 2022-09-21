package com.kurdestanbootcamp.snapfood.basket_item;



import java.util.List;

public interface IBasketItemService {

    BasketItem save(BasketItem basketItem);
    BasketItem update(BasketItem basketItem);
    void delete(Long id);
    BasketItem getById(Long id);
    List<BasketItem> getAll();

    List<BasketItem> getAllByBasket(Long basketId);

    List<BasketItem> getAllByItem(Long itemId);




}
