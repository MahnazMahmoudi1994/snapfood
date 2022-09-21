package com.kurdestanbootcamp.snapfood.supplier_category;


import com.kurdestanbootcamp.snapfood.common.BaseDTO;
import com.kurdestanbootcamp.snapfood.supplier.Supplier;
import com.kurdestanbootcamp.snapfood.supplier.SupplierDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



@Data
public class SupplierCategoryDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String title;

    @ApiModelProperty(required = true,hidden = false)
    private String logo;

    @ApiModelProperty(required = true,hidden = false)
    private SupplierDTO supplier;


}
