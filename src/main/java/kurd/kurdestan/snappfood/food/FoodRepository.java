package kurd.kurdestan.snappfood.food;

import kurd.kurdestan.snappfood.supplier_category.SupplierCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends PagingAndSortingRepository<Food ,Long> , JpaSpecificationExecutor<Food> {
    Food findByName(String name);
    List<Food> findBySupplierCategory(SupplierCategory supplierCategory );
    List<Food>findAllBySupplierCategory_Supplier(SupplierCategory supplierCategory);

    List<Food> findAll(Specification<Food> specification);

}
