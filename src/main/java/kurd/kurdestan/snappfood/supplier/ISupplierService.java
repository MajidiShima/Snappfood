package kurd.kurdestan.snappfood.supplier;


import kurd.kurdestan.snappfood.category.Category;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import java.util.List;

public interface ISupplierService {

    Supplier save(Supplier supplier);
    Supplier update(Supplier supplier);
    List<Supplier> getAllByCategoryId(Long categoryId);
    List<Supplier> findNearest(Point<G2D> candidPoint, double distance);
    Supplier getById(Long id);
    Supplier getAllByName(String name);
    List<Supplier>getALL();

}
