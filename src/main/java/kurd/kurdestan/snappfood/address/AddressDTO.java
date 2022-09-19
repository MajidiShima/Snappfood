package kurd.kurdestan.snappfood.address;


import io.swagger.annotations.ApiModelProperty;
import kurd.kurdestan.snappfood.common.BaseDTO;
import kurd.kurdestan.snappfood.user.User;
import lombok.Data;

@Data
public class AddressDTO extends BaseDTO {
    @ApiModelProperty(required = true,hidden = false)
    private String title;
    @ApiModelProperty(required = true,hidden = false)
    private String address;
    @ApiModelProperty(required = false,hidden = false)
    private User user;
}
