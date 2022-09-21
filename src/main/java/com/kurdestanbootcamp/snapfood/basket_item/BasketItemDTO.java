package com.kurdestanbootcamp.snapfood.basket_item;

import com.kurdestanbootcamp.snapfood.basket.BasketDTO;
import com.kurdestanbootcamp.snapfood.common.BaseDTO;
import com.kurdestanbootcamp.snapfood.item.ItemDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BasketItemDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private Integer count;

    @ApiModelProperty(required = true,hidden = false)
    private BasketDTO basket;

    @ApiModelProperty(required = true,hidden = false)
    private ItemDTO item;


}
