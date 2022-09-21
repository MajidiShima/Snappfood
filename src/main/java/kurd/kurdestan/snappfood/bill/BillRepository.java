package kurd.kurdestan.snappfood.bill;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository  extends PagingAndSortingRepository<Bill,Long> {


}
