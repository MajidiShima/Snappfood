package kurd.kurdestan.snappfood.basket;

import io.swagger.annotations.ApiModelProperty;
import kurd.kurdestan.snappfood.address.AddressDTO;
import kurd.kurdestan.snappfood.common.BaseDTO;
import kurd.kurdestan.snappfood.supplier.SupplierDTO;
import lombok.Data;

@Data
public class BasketDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private Status status ;
    @ApiModelProperty(required = true,hidden = false)
    private String paidPrice;
    @ApiModelProperty(required = true,hidden = false)
    private SupplierDTO supplier;
    @ApiModelProperty(required = true,hidden = false)
    private AddressDTO address;

}
