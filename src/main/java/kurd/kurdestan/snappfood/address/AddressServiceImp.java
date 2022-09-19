package kurd.kurdestan.snappfood.address;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class AddressServiceImp implements IAddressService{

    private final AddressRepository repository;
    // TODO: 9/18/2022 plz to cal father service (user)


    @Override
    public Address save(Address address) {
        return null;
    }

    @Override
    public Address update(Address address) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Address getAll() {
        return null;
    }

    @Override
    public Address getById(Long id) {
        return null;
    }

    @Override
    public Address getAllByTitle(String title) {
        return null;
    }

    @Override
    public List<Address> getByUserId(Long userId) {
        return null;
    }
}
