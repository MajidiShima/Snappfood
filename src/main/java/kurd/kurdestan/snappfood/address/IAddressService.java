package kurd.kurdestan.snappfood.address;

import java.util.List;

public interface IAddressService {

    Address save(Address address);
    Address update(Address address);
    void delete(Long id);
    List<Address> getAll();
    Address getById(Long id);
    List<Address> getAllByTitle(String title);
    List<Address> getAllByUserId(Long userId);
}
