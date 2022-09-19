package kurd.kurdestan.snappfood.user;

import java.util.List;

public interface IUserService {
    User save(User user);
    User update(User user);
    List<User>getAllByName(String name);
    User getById(Long id);
    void deleteById(Long id);

}
