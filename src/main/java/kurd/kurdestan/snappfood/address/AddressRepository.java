package kurd.kurdestan.snappfood.address;


import kurd.kurdestan.snappfood.user.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {

  List<Address> findAllByTitle(String title);
    List<Address>findAllByUserId(Long userId);


}
