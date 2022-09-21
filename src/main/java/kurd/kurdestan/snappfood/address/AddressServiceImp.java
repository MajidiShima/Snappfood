package kurd.kurdestan.snappfood.address;

import kurd.kurdestan.snappfood.user.IUserService;
import kurd.kurdestan.snappfood.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class AddressServiceImp implements IAddressService{

    private final AddressRepository repository;
    private IUserService userService;


    @Override
    public Address save(Address address) {
        Long addressId = address.getUser().getId();
        User user= userService.getById(addressId);
        address.setUser(user);
        return repository.save(address);
    }

    @Override
    public Address update(Address address) {
        Address lastAddress=getById(address.getId());

        lastAddress.setAddress(address.getAddress());
        lastAddress.setTitle(address.getTitle());
        Long userId=address.getUser().getId();
        User user=userService.getById(userId);
        lastAddress.setUser(user);
        return repository.save(lastAddress);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    @Override
    public List<Address> getAll() {
      return (List<Address>) repository.findAll();

    }

    @Override
    public Address getById(Long id) {
        Optional<Address> optional=repository.findById(id);
        if(optional.isEmpty()){
            throw new NotFoundException("Address Not Found");
        }
        return optional.get();
    }

    @Override
    public List<Address> getAllByTitle(String title) {
        return repository.findAllByTitle(title);
    }

    @Override
    public List<Address> getAllByUserId(Long userId) {
        User user=userService.getById(userId);
        return repository.findAllByUserId(user.getId());
    }


}
