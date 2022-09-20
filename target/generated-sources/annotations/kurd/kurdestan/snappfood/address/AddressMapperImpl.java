package kurd.kurdestan.snappfood.address;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-20T10:22:03+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.4.1 (Amazon.com Inc.)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public Address toAddress(AddressDTO addressDTO) {
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

    @Override
    public AddressDTO toAddressDTO(Address address) {
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

    @Override
    public List<Address> toAddressList(List<AddressDTO> addressDTO) {
        if ( addressDTO == null ) {
            return null;
        }

        List<Address> list = new ArrayList<Address>( addressDTO.size() );
        for ( AddressDTO addressDTO1 : addressDTO ) {
            list.add( toAddress( addressDTO1 ) );
        }

        return list;
    }

    @Override
    public List<AddressDTO> toAddressListDTO(List<Address> addressList) {
        if ( addressList == null ) {
            return null;
        }

        List<AddressDTO> list = new ArrayList<AddressDTO>( addressList.size() );
        for ( Address address : addressList ) {
            list.add( toAddressDTO( address ) );
        }

        return list;
    }
}
