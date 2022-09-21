package com.kurdestanbootcamp.snapfood.item;


import com.kurdestanbootcamp.snapfood.common.BaseDTO;
import com.kurdestanbootcamp.snapfood.supplier_category.SupplierCategory;
import com.kurdestanbootcamp.snapfood.supplier_category.SupplierCategoryDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;


@Data
public class ItemDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String name;

    @ApiModelProperty(required = false,hidden = false)
    private String description;

    @ApiModelProperty(required = true,hidden = false)
    private Double price;

    @ApiModelProperty(required = false,hidden = false)
    private String image;

    @ApiModelProperty(required = true,hidden = false)
    private SupplierCategoryDTO supplierCategory;


}
