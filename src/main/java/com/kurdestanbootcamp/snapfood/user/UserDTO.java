package com.kurdestanbootcamp.snapfood.user;


import com.kurdestanbootcamp.snapfood.common.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



@Data
public class UserDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String firstName;

    @ApiModelProperty(required = true,hidden = false)
    private String lastName;

    @ApiModelProperty(required = true,hidden = false)
    private String phoneNumber;


}
