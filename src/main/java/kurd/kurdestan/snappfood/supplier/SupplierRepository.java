package kurd.kurdestan.snappfood.supplier;



import kurd.kurdestan.snappfood.category.Category;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;
import java.util.Optional;

@Repository
public interface SupplierRepository extends PagingAndSortingRepository<Supplier ,Long>, JpaSpecificationExecutor<Supplier> {


    Optional<Supplier> findAllByName(String title);
    List<Supplier> findAllByCategory_Id(Long categoryId);

    @Query("select plc from Supplier plc where distance(plc.location, ?1) <?2")
    List<Supplier> findAllWithDistance(Point<G2D> refPnt, double dist);

    @Query("select plc,distance(plc.location, ?1) as distance from Supplier  plc order by distance")
    List<Tuple> findNearest(Point<G2D> refPnt);



    // TODO: 9/17/2022 set these methods plz
    List<Supplier> findAll(Specification<Supplier> specification);
    Page<Supplier> findAll   (Specification<Supplier> specification, Pageable pageable);


}
