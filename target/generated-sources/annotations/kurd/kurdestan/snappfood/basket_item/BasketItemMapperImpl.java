package kurd.kurdestan.snappfood.basket_item;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-20T19:26:01+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.4.1 (Amazon.com Inc.)"
)
@Component
public class BasketItemMapperImpl implements BasketItemMapper {

    @Override
    public BasketItem toBasketItem(BasketItemDTO basketItemDTO) {
        if ( basketItemDTO == null ) {
            return null;
        }

        BasketItem basketItem = new BasketItem();

        basketItem.setId( basketItemDTO.getId() );
        basketItem.setVersion( basketItemDTO.getVersion() );
        basketItem.setCreatedDate( basketItemDTO.getCreatedDate() );
        basketItem.setCreatedBy( basketItemDTO.getCreatedBy() );
        basketItem.setLastModifiedDate( basketItemDTO.getLastModifiedDate() );
        basketItem.setLastModifiedBy( basketItemDTO.getLastModifiedBy() );
        basketItem.setCount( basketItemDTO.getCount() );
        basketItem.setBasket( basketItemDTO.getBasket() );
        basketItem.setFood( basketItemDTO.getFood() );

        return basketItem;
    }

    @Override
    public BasketItemDTO toBasketItemDTO(BasketItem basketItem) {
        if ( basketItem == null ) {
            return null;
        }

        BasketItemDTO basketItemDTO = new BasketItemDTO();

        basketItemDTO.setId( basketItem.getId() );
        basketItemDTO.setVersion( basketItem.getVersion() );
        basketItemDTO.setCreatedDate( basketItem.getCreatedDate() );
        basketItemDTO.setCreatedBy( basketItem.getCreatedBy() );
        basketItemDTO.setLastModifiedDate( basketItem.getLastModifiedDate() );
        basketItemDTO.setLastModifiedBy( basketItem.getLastModifiedBy() );
        basketItemDTO.setCount( basketItem.getCount() );
        basketItemDTO.setBasket( basketItem.getBasket() );
        basketItemDTO.setFood( basketItem.getFood() );

        return basketItemDTO;
    }

    @Override
    public List<BasketItem> toBasketItemList(List<BasketItemDTO> basketItemDTOList) {
        if ( basketItemDTOList == null ) {
            return null;
        }

        List<BasketItem> list = new ArrayList<BasketItem>( basketItemDTOList.size() );
        for ( BasketItemDTO basketItemDTO : basketItemDTOList ) {
            list.add( toBasketItem( basketItemDTO ) );
        }

        return list;
    }

    @Override
    public List<BasketItemDTO> toBasketItemListDTO(List<BasketItem> basketItemList) {
        if ( basketItemList == null ) {
            return null;
        }

        List<BasketItemDTO> list = new ArrayList<BasketItemDTO>( basketItemList.size() );
        for ( BasketItem basketItem : basketItemList ) {
            list.add( toBasketItemDTO( basketItem ) );
        }

        return list;
    }
}
