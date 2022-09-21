package com.kurdestanbootcamp.snapfood.basket;

import com.kurdestanbootcamp.snapfood.address.AddressDTO;
import com.kurdestanbootcamp.snapfood.common.BaseDTO;
import com.kurdestanbootcamp.snapfood.supplier.SupplierDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class BasketDTO extends BaseDTO {

    @ApiModelProperty(required = false,hidden = false)
    private Double paidPrice;

    @ApiModelProperty(required = false,hidden = false)
    private Boolean status;

    @ApiModelProperty(required = true,hidden = false)
    private AddressDTO address;

    @ApiModelProperty(required = true,hidden = false)
    private SupplierDTO supplier;
}
