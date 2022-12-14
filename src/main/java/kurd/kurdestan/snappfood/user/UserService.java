package kurd.kurdestan.snappfood.user;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService implements IUserService {

    private final UserRepository repository;

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public User update(User user) {
        User lastUser=getById(user.getId());

        lastUser.setImage(user.getImage());
        lastUser.setLastName(user.getLastName());
        lastUser.setName(user.getName());
        lastUser.setPhone(user.getPhone());
        lastUser.setPassWord(user.getPassWord());

        return repository.save(lastUser);
    }

    @Override
    public List<User> getAllByName(String name) {

        return repository.findAllByName(name);
    }

    @Override
    public User getById(Long id) {
        Optional<User> optional=repository.findById(id);
        if(!optional.isPresent()){
            throw  new NotFoundException("User Not Found ");
        }
        return optional.get();
    }

    @Override
    public void deleteById(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    @Override
    public User getByPhone(Long phone) {
       return repository.findByPhone(phone);
    }
}
