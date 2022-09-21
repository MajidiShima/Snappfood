package kurd.kurdestan.snappfood.basket;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kurd.kurdestan.snappfood.address.Address;
import kurd.kurdestan.snappfood.address.AddressDTO;
import kurd.kurdestan.snappfood.supplier.SupplierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-20T19:26:01+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.4.1 (Amazon.com Inc.)"
)
@Component
public class BasketMapperImpl implements BasketMapper {

    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public Basket toBasket(BasketDTO basketDTO) {
        if ( basketDTO == null ) {
            return null;
        }

        Basket basket = new Basket();

        basket.setId( basketDTO.getId() );
        basket.setVersion( basketDTO.getVersion() );
        basket.setCreatedDate( basketDTO.getCreatedDate() );
        basket.setCreatedBy( basketDTO.getCreatedBy() );
        basket.setLastModifiedDate( basketDTO.getLastModifiedDate() );
        basket.setLastModifiedBy( basketDTO.getLastModifiedBy() );
        basket.setStatus( basketDTO.getStatus() );
        basket.setPaidPrice( basketDTO.getPaidPrice() );
        basket.setSupplier( supplierMapper.toSupplier( basketDTO.getSupplier() ) );
        basket.setAddress( addressDTOToAddress( basketDTO.getAddress() ) );

        return basket;
    }

    @Override
    public BasketDTO toBasketDTO(Basket basket) {
        if ( basket == null ) {
            return null;
        }

        BasketDTO basketDTO = new BasketDTO();

        basketDTO.setId( basket.getId() );
        basketDTO.setVersion( basket.getVersion() );
        basketDTO.setCreatedDate( basket.getCreatedDate() );
        basketDTO.setCreatedBy( basket.getCreatedBy() );
        basketDTO.setLastModifiedDate( basket.getLastModifiedDate() );
        basketDTO.setLastModifiedBy( basket.getLastModifiedBy() );
        basketDTO.setStatus( basket.getStatus() );
        basketDTO.setPaidPrice( basket.getPaidPrice() );
        basketDTO.setSupplier( supplierMapper.toSupplierDTO( basket.getSupplier() ) );
        basketDTO.setAddress( addressToAddressDTO( basket.getAddress() ) );

        return basketDTO;
    }

    @Override
    public List<Basket> toBasketList(List<BasketDTO> basketDTOList) {
        if ( basketDTOList == null ) {
            return null;
        }

        List<Basket> list = new ArrayList<Basket>( basketDTOList.size() );
        for ( BasketDTO basketDTO : basketDTOList ) {
            list.add( toBasket( basketDTO ) );
        }

        return list;
    }

    @Override
    public List<BasketDTO> toBasketDTOS(List<Basket> basketList) {
        if ( basketList == null ) {
            return null;
        }

        List<BasketDTO> list = new ArrayList<BasketDTO>( basketList.size() );
        for ( Basket basket : basketList ) {
            list.add( toBasketDTO( basket ) );
        }

        return list;
    }

    protected Address addressDTOToAddress(AddressDTO addressDTO) {
        if ( addressDTO == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( addressDTO.getId() );
        address.setVersion( addressDTO.getVersion() );
        address.setCreatedDate( addressDTO.getCreatedDate() );
        address.setCreatedBy( addressDTO.getCreatedBy() );
        address.setLastModifiedDate( addressDTO.getLastModifiedDate() );
        address.setLastModifiedBy( addressDTO.getLastModifiedBy() );
        address.setTitle( addressDTO.getTitle() );
        address.setAddress( addressDTO.getAddress() );
        address.setUser( addressDTO.getUser() );

        return address;
    }

    protected AddressDTO addressToAddressDTO(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setId( address.getId() );
        addressDTO.setVersion( address.getVersion() );
        addressDTO.setCreatedDate( address.getCreatedDate() );
        addressDTO.setCreatedBy( address.getCreatedBy() );
        addressDTO.setLastModifiedDate( address.getLastModifiedDate() );
        addressDTO.setLastModifiedBy( address.getLastModifiedBy() );
        addressDTO.setTitle( address.getTitle() );
        addressDTO.setAddress( address.getAddress() );
        addressDTO.setUser( address.getUser() );

        return addressDTO;
    }
}
