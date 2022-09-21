package kurd.kurdestan.snappfood.basket;

import kurd.kurdestan.snappfood.address.Address;
import kurd.kurdestan.snappfood.category.Category;
import kurd.kurdestan.snappfood.supplier.Supplier;
import kurd.kurdestan.snappfood.supplier_category.SupplierCategory;
import kurd.kurdestan.snappfood.user.User;

import java.util.List;

public interface IBasketService {

Basket save(Basket basket);
Basket update(Basket basket);
void deleteById(Long id);
Basket getById(Long id);
List<Basket>getAll();

    List<Basket> getAllBySupplier(Long supplierId);
    List<Basket>getAllByAddress(Long addressId);
    List<Basket>getAllByAddress_User(Long userId);
    List<Basket>getAllBySupplier_Category(Long categoryId);
    List<Basket>getAllBySupplier_SupplierCategories(Long supplierCategoryId);


}
