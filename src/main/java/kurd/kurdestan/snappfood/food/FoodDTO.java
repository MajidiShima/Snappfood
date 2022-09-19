package kurd.kurdestan.snappfood.food;

import io.swagger.annotations.ApiModelProperty;
import kurd.kurdestan.snappfood.common.BaseDTO;
import kurd.kurdestan.snappfood.supplier_category.SupplierCategory;
import lombok.Data;

@Data
public class FoodDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String name;
    @ApiModelProperty(required = false,hidden = false)
    private String image;
    @ApiModelProperty(required = false,hidden = false)
    private String description;
    @ApiModelProperty(required = false,hidden = false)
    private SupplierCategory supplierCategory;

}
