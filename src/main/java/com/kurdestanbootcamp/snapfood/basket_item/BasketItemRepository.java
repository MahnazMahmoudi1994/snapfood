package com.kurdestanbootcamp.snapfood.basket_item;


import com.kurdestanbootcamp.snapfood.basket.Basket;
import com.kurdestanbootcamp.snapfood.item.Item;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BasketItemRepository extends PagingAndSortingRepository<BasketItem, Long> {

List<BasketItem> findAllByBasket(Basket basket);
List<BasketItem> findAllByItem(Item item);


}