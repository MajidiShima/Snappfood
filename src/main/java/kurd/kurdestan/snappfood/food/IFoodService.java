package kurd.kurdestan.snappfood.food;


import kurd.kurdestan.snappfood.common.SearchCriteria;

import java.util.List;


public interface IFoodService {
    Food save(Food food);
    Food update(Food food);
    void deleteBYId(Long id);
    Food getAllByName(String name);
    Food getById(Long id);
    List<Food> getBySupplierCategoryById(Long SupplierCategoryId );
    List<Food>getAllBySupplierCategory_SupplierId (Long supplierId);
    List<Food>search(List<SearchCriteria> searchCriteria);
}
