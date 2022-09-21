package kurd.kurdestan.snappfood.basket;


import kurd.kurdestan.snappfood.supplier.SupplierMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {SupplierMapper.class, BasketMapper.class})
public interface BasketMapper {

    Basket toBasket(BasketDTO basketDTO);
    BasketDTO toBasketDTO(Basket basket);
    List<Basket> toBasketList(List<BasketDTO> basketDTOList);
    List<BasketDTO> toBasketDTOS(List<Basket> basketList);

}
