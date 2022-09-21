package kurd.kurdestan.snappfood.bill;

import io.swagger.annotations.ApiModelProperty;
import kurd.kurdestan.snappfood.common.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BillDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private BigDecimal totalPrice;

}
