package kurd.kurdestan.snappfood.basket;


import kurd.kurdestan.snappfood.address.Address;
import kurd.kurdestan.snappfood.category.Category;
import kurd.kurdestan.snappfood.supplier.Supplier;
import kurd.kurdestan.snappfood.supplier_category.SupplierCategory;
import kurd.kurdestan.snappfood.user.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketRepository extends PagingAndSortingRepository<Basket, Long> {

    List<Basket>findAllBySupplier(Supplier supplier);
    List<Basket>findAllByAddress(Address address);
    List<Basket>findAllByAddress_User(User user);
    List<Basket>findAllBySupplier_Category(Category category);
    List<Basket>findAllBySupplier_SupplierCategories(SupplierCategory supplierCategory);


}
