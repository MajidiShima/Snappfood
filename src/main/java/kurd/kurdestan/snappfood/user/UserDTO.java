package kurd.kurdestan.snappfood.user;

import io.swagger.annotations.ApiModelProperty;
import kurd.kurdestan.snappfood.common.BaseDTO;
import lombok.Data;

@Data
public class UserDTO extends BaseDTO {
    @ApiModelProperty(required = true,hidden = false)
    private String name;
    @ApiModelProperty(required = true,hidden = false)
    private String lastName;
    @ApiModelProperty(required = true,hidden = false)
    private Integer passWord;
    @ApiModelProperty(required = true,hidden = false)
    private String image;
    @ApiModelProperty(required = true,hidden = false)
    private Integer phone;

}
