package kurd.kurdestan.snappfood.user;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User,Long> {
    List<User> findAllByName(String name);
    List<User>findAllById(Long id);

}
