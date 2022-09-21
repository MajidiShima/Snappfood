package kurd.kurdestan.snappfood.basket_item;


import io.swagger.annotations.ApiModelProperty;
import kurd.kurdestan.snappfood.basket.Basket;
import kurd.kurdestan.snappfood.common.BaseDTO;
import kurd.kurdestan.snappfood.food.Food;
import lombok.Data;

@Data
public class BasketItemDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private Integer count;

    @ApiModelProperty(required = false,hidden = false)
    private Basket basket;
    @ApiModelProperty(required = false,hidden = false)
    private Food food;

}
