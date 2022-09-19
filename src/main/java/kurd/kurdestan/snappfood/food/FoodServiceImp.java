package kurd.kurdestan.snappfood.food;

import kurd.kurdestan.snappfood.common.SearchCriteria;
import kurd.kurdestan.snappfood.supplier.ISupplierService;
import kurd.kurdestan.snappfood.supplier.Supplier;
import kurd.kurdestan.snappfood.supplier_category.ISupplierCategoryService;
import kurd.kurdestan.snappfood.supplier_category.SupplierCategory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class FoodServiceImp implements IFoodService {

    private final FoodRepository repository;

    private ISupplierService supplierService;
    private ISupplierCategoryService supplierCategoryService;


    @Override
    public Food save(Food food) {
        Long supplierCategoryId = food.getSupplierCategory().getId();
        SupplierCategory supplierCategory = supplierCategoryService.getById(supplierCategoryId);
        food.setSupplierCategory(supplierCategory);
        return repository.save(food);
    }

    @Override
    public Food update(Food food) {
        Food lastFood = getById(food.getId());
        lastFood.setImage(food.getImage());
        lastFood.setDescription(food.getDescription());
        lastFood.setPrice(food.getPrice());

        Long supplierCategory = food.getSupplierCategory().getId();
        SupplierCategory supplierCategory1 = supplierCategoryService.getById(supplierCategory);
        lastFood.setSupplierCategory(supplierCategory1);

        return repository.save(lastFood);
    }

    @Override
    public void deleteBYId(Long id) {

        getById(id);
        repository.deleteById(id);
    }

    @Override
    public Food getAllByName(String name) {
        Optional<Food> optional = Optional.ofNullable(repository.findByName(name));
        if (!optional.isPresent()) {
            throw new NotFoundException("Food not Found");
        }
        return optional.get();
    }

    @Override
    public Food getById(Long id) {
        Optional<Food> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new NotFoundException("Food not Found");
        }
        return optional.get();
    }

    @Override
    public List<Food> getBySupplierCategoryById(Long SupplierCategoryId) {
        SupplierCategory supplierCategory = supplierCategoryService.getById(SupplierCategoryId);
        return repository.findBySupplierCategory(supplierCategory);
    }

    @Override
    public List<Food> getAllBySupplierCategory_SupplierId(Long supplierId) {

        Supplier supplier = supplierService.getById(supplierId);

        return repository.findAllBySupplierCategory_Supplier(supplier);

    }

    @Override
    public List<Food> search(List<SearchCriteria> searchCriteria) {
        FoodSpecifcation foodSpecifcation = new FoodSpecifcation();
        searchCriteria.forEach(criteria -> foodSpecifcation.add(criteria));

        return repository.findAll(foodSpecifcation);
    }


}
