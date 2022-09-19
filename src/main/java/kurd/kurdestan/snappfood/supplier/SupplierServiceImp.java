package kurd.kurdestan.snappfood.supplier;

import kurd.kurdestan.snappfood.category.Category;
import kurd.kurdestan.snappfood.category.ICategoryService;
import lombok.AllArgsConstructor;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor

public class SupplierServiceImp implements ISupplierService {
    private final SupplierRepository repository;

    private final ICategoryService categoryService;

    @Override
    public Supplier save(Supplier supplier) {
        Long categoryId = supplier.getCategory().getId();
        Category category = categoryService.getById(categoryId);
        supplier.setCategory(category);

        return repository.save(supplier);
    }

    @Override
    public Supplier update(Supplier supplier) {

        Supplier lastSupplier = getById(supplier.getId());
        lastSupplier.setAddress(supplier.getAddress());
        lastSupplier.setImage(supplier.getImage());
        lastSupplier.setBaskets(supplier.getBaskets());
        lastSupplier.setLocation(supplier.getLocation());
        lastSupplier.setName(supplier.getName());

        Long categoryId = supplier.getCategory().getId();
        Category category = categoryService.getById(categoryId);
        lastSupplier.setCategory(category);

        return repository.save(lastSupplier);
    }

    @Override
    public List<Supplier> getAllByCategoryId(Long categoryId) {
        Category category = categoryService.getById(categoryId);
        return  repository.findAllByCategory_Id(category.getId());
    }

    @Override
    public List<Supplier> findNearest(Point<G2D> candidPoint, double distance) {
        return repository.findAllWithDistance(candidPoint,distance);
    }

    @Override
    public Supplier getById(Long id) {
        Optional<Supplier> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new NotFoundException("Supplier Not Found");
        }
        return optional.get();
    }

    @Override
    public Supplier getAllByName(String name) {

        Optional<Supplier> optionalSupplier = repository.findAllByName(name);
        if (optionalSupplier.isEmpty()) {
            throw new NotFoundException("Name Not Found");
        }
        return optionalSupplier.get();
    }

    @Override
    public List<Supplier> getALL() {
        return (List<Supplier>) repository.findAll();
    }
}
