package kurd.kurdestan.snappfood.supplier_category;

import kurd.kurdestan.snappfood.supplier.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface SupplierCategoryRepository extends PagingAndSortingRepository<SupplierCategory ,Long> , JpaSpecificationExecutor<SupplierCategory> {


    List<SupplierCategory> findAllBySupplier(Supplier supplier);
    SupplierCategory findAllByName(String name);
    Optional<SupplierCategory> findById(Long id);

    Page<SupplierCategory>findAll(Pageable pageable);

    List<SupplierCategory> findAll(Specification<SupplierCategory> specification);
    Page<SupplierCategory> findAll   (Specification<SupplierCategory> specification, Pageable pageable);


}
