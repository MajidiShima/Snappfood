package kurd.kurdestan.snappfood.supplier;


import kurd.kurdestan.snappfood.category.Category;
import kurd.kurdestan.snappfood.common.SearchCriteria;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ISupplierService {

    Supplier save(Supplier supplier);
    Supplier update(Supplier supplier);
    List<Supplier> getAllByCategoryId(Long categoryId);
    List<Supplier> findNearest(Point<G2D> candidPoint, double distance);
    Supplier getById(Long id);
    Supplier getAllByName(String name);
    List<Supplier>getALL();

    List<Supplier> search(List<SearchCriteria> searchCriteria);
    Page<Supplier> paging(Integer page, Integer size);
    Page<Supplier> searchPaging(List<SearchCriteria> searchCriteria, Integer page, Integer size);

}
