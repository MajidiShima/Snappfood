package kurd.kurdestan.snappfood.category;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category,Long>, JpaSpecificationExecutor<Category> {


    Optional<Category> findByTitle(String title);


    List<Category> findAll(Specification<Category> specification);
    Page<Category> findAll   (Specification<Category> specification, Pageable pageable);

}
