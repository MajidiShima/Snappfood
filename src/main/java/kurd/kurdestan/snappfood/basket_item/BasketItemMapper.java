package kurd.kurdestan.snappfood.basket_item;


import kurd.kurdestan.snappfood.basket.BasketMapper;
import kurd.kurdestan.snappfood.food.FoodMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {FoodMapper.class, BasketMapper.class})
public interface BasketItemMapper {
    BasketItem toBasketItem(BasketItemDTO basketItemDTO);
    BasketItemDTO toBasketItemDTO(BasketItem basketItem);
    List<BasketItem> toBasketItemList(List<BasketItemDTO> basketItemDTOList);
    List<BasketItemDTO> toBasketItemListDTO(List<BasketItem> basketItemList);



}
