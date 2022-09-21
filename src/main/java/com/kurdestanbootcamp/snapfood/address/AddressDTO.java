package com.kurdestanbootcamp.snapfood.address;


import com.kurdestanbootcamp.snapfood.common.BaseDTO;
import com.kurdestanbootcamp.snapfood.common.LocationDTO;
import com.kurdestanbootcamp.snapfood.user.User;
import com.kurdestanbootcamp.snapfood.user.UserDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddressDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private LocationDTO locationDTO;

    @ApiModelProperty(required = true,hidden = false)
    private String address;

    @ApiModelProperty(required = false,hidden = false)
    private String details;

    @ApiModelProperty(required = true,hidden = false)
    private String phoneNumber;

    @ApiModelProperty(required = true,hidden = false)
    private UserDTO user;
}
