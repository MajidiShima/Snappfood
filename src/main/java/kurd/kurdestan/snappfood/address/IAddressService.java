package kurd.kurdestan.snappfood.address;

import kurd.kurdestan.snappfood.user.User;

import java.util.List;

public interface IAddressService {

    Address save(Address address);
    Address update(Address address);
    void delete(Long id);
    Address getAll();
    Address getById(Long id);
    Address getAllByTitle(String title);
    List<Address> getByUserId(Long userId);
}
