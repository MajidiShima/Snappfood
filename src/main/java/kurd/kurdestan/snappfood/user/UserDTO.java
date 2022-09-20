package kurd.kurdestan.snappfood.user;

import io.swagger.annotations.ApiModelProperty;
import kurd.kurdestan.snappfood.common.BaseDTO;
import lombok.Data;

@Data
public class UserDTO extends BaseDTO {
    @ApiModelProperty(required = false,hidden = false)
    private String name;
    @ApiModelProperty(required = false,hidden = false)
    private String lastName;
    @ApiModelProperty(required = false,hidden = true)
    private Integer passWord;
    @ApiModelProperty(required = false,hidden = true)
    private String image;
    @ApiModelProperty(required = false,hidden = true)
    private Integer phone;

}
