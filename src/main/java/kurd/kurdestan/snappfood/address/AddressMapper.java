package kurd.kurdestan.snappfood.address;

import kurd.kurdestan.snappfood.user.UserMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {UserMapper.class})
public interface AddressMapper  {

    Address toAddress(AddressDTO addressDTO);
    AddressDTO toAddressDTO(Address address);
    List<Address> toAddressList(List<AddressDTO> addressDTO);
    List<AddressDTO>toAddressDTO(List<Address> addressList);


}
