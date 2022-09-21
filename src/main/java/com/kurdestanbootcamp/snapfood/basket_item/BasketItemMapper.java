package com.kurdestanbootcamp.snapfood.basket_item;

import com.kurdestanbootcamp.snapfood.basket.BasketMapper;
import com.kurdestanbootcamp.snapfood.item.ItemMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BasketMapper.class, ItemMapper.class})
public interface BasketItemMapper {

    BasketItem toBasketItem(BasketItemDTO basketItemDTO);

    BasketItemDTO toBasketItemDTO(BasketItem basketItem);

    List<BasketItemDTO> toBasketItemDTOS(List<BasketItem> basketItems);

    List<BasketItem> toBasketItems(List<BasketItemDTO> basketItemDTOS);

}
