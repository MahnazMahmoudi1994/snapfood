package com.kurdestanbootcamp.snapfood.basket;

import com.kurdestanbootcamp.snapfood.address.AddressMapper;
import com.kurdestanbootcamp.snapfood.supplier.SupplierMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AddressMapper.class, SupplierMapper.class})
public interface BasketMapper {

    Basket toBasket(BasketDTO basketDTO);

    BasketDTO toBasketDTO(Basket basket);

    List<BasketDTO> toBasketDTOS(List<Basket> baskets);

    List<Basket> toBaskets(List<BasketDTO> basketDTOS);

}
