package com.kurdestanbootcamp.snapfood.item;

import com.kurdestanbootcamp.snapfood.supplier_category.SupplierCategoryMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SupplierCategoryMapper.class})
public interface ItemMapper {


    Item toItem(ItemDTO itemDTO);

    ItemDTO toItemDTO(Item item);

    List<ItemDTO> toItemDTOS(List<Item> items);

    List<Item> toItems(List<ItemDTO> itemDTOS);


}
