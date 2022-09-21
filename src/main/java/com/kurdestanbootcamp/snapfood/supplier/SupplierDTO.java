package com.kurdestanbootcamp.snapfood.supplier;

import com.kurdestanbootcamp.snapfood.category.CategoryDTO;
import com.kurdestanbootcamp.snapfood.common.BaseDTO;
import com.kurdestanbootcamp.snapfood.common.LocationDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class SupplierDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String name;

    @ApiModelProperty(required = true,hidden = false)
    private LocationDTO locationDTO;

    @ApiModelProperty(required = true,hidden = false)
    private String address;

    @ApiModelProperty(required = false,hidden = false)
    private String logo;

    @ApiModelProperty(required = true,hidden = false)
    private CategoryDTO category;


}
