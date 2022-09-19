package kurd.kurdestan.snappfood.address;


import kurd.kurdestan.snappfood.user.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {

    Optional<Address> findAllByTitle(String title);
    List<Address>findByUser(User user);



}
