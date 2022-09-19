package kurd.kurdestan.snappfood.supplier_category;

import io.swagger.annotations.ApiModelProperty;
import kurd.kurdestan.snappfood.common.BaseDTO;
import kurd.kurdestan.snappfood.supplier.Supplier;
import lombok.Data;

@Data
public class SupplierCategoryDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String name;
    @ApiModelProperty(required = true,hidden = false)
    private String address;
    @ApiModelProperty(required = true,hidden = false)
    private Supplier supplier;


}
