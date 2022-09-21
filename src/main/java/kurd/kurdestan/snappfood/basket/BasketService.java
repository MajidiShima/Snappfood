package kurd.kurdestan.snappfood.basket;


import kurd.kurdestan.snappfood.address.Address;
import kurd.kurdestan.snappfood.address.IAddressService;
import kurd.kurdestan.snappfood.category.Category;
import kurd.kurdestan.snappfood.category.ICategoryService;
import kurd.kurdestan.snappfood.supplier.ISupplierService;
import kurd.kurdestan.snappfood.supplier.Supplier;
import kurd.kurdestan.snappfood.supplier_category.ISupplierCategoryService;
import kurd.kurdestan.snappfood.supplier_category.SupplierCategory;
import kurd.kurdestan.snappfood.user.IUserService;
import kurd.kurdestan.snappfood.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class BasketService implements IBasketService {
    private final BasketRepository repository;

    private final IAddressService addressService;
    private final ISupplierService supplierService;
    private final ICategoryService categoryService;
    private final IUserService userService;
    private final ISupplierCategoryService supplierCategoryService;

    @Override
    public Basket save(Basket basket) {
        Long addressId = basket.getAddress().getId();
        Long supplierId = basket.getSupplier().getId();
        Address address = addressService.getById(addressId);
        Supplier supplier = supplierService.getById(supplierId);
        basket.setAddress(address);
        basket.setSupplier(supplier);
        return repository.save(basket);

    }

    @Override
    public Basket update(Basket basket) {
        Basket lastBasket = getById(basket.getId());
        lastBasket.setStatus(basket.getStatus());
        lastBasket.setPaidPrice(basket.getPaidPrice());

        Long addressId1 = basket.getAddress().getId();
        Long supplierId = basket.getSupplier().getId();
        Address address = addressService.getById(addressId1);
        Supplier supplier = supplierService.getById(supplierId);
        lastBasket.setAddress(address);
        lastBasket.setSupplier(supplier);
        return repository.save(lastBasket);
    }

    @Override
    public void deleteById(Long id) {
        getById(id);
        repository.deleteById(id);

    }

    @Override
    public Basket getById(Long id) {
        Optional<Basket> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new NotFoundException("Basket Not Found");
        }
        return optional.get();
    }

    @Override
    public List<Basket> getAll() {
        return (List<Basket>) repository.findAll();
    }

    @Override
    public List<Basket> getAllBySupplier(Long supplierId) {
        Supplier supplier = supplierService.getById(supplierId);
        return repository.findAllBySupplier(supplier);
    }

    @Override
    public List<Basket> getAllByAddress(Long addressId) {
        Address address = addressService.getById(addressId);
        return repository.findAllByAddress(address);
    }

    @Override
    public List<Basket> getAllByAddress_User(Long userId) {
        User user = userService.getById(userId);
        return repository.findAllByAddress_User(user);
    }

    @Override
    public List<Basket> getAllBySupplier_Category(Long categoryId) {
        Category category = categoryService.getById(categoryId);
        return repository.findAllBySupplier_Category(category);
    }

    @Override
    public List<Basket> getAllBySupplier_SupplierCategories(Long supplierCategoryId) {
        SupplierCategory supplierCategory = supplierCategoryService.getById(supplierCategoryId);
        return repository.findAllBySupplier_SupplierCategories(supplierCategory);
    }



}