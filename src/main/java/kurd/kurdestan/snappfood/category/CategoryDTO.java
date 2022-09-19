package kurd.kurdestan.snappfood.category;


import io.swagger.annotations.ApiModelProperty;
import kurd.kurdestan.snappfood.common.BaseDTO;
import lombok.Data;


@Data

public class CategoryDTO extends BaseDTO {
    @ApiModelProperty(required = true,hidden = false)
    private String title;

    @ApiModelProperty(required = false,hidden = false)
    private String image;

    @ApiModelProperty(required = true,hidden = false)
    private TypeOfCategory typeOfCategory;




}
