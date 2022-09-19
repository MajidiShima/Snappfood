package kurd.kurdestan.snappfood.supplier_category;


import kurd.kurdestan.snappfood.common.SearchCriteria;
import kurd.kurdestan.snappfood.supplier.ISupplierService;
import kurd.kurdestan.snappfood.supplier.Supplier;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor

public class SupplierCategoryServiceImp implements ISupplierCategoryService {

    private final SupplierCategoryRepository repository;
    private final ISupplierService supplierService;


    @Override
    public List<SupplierCategory> getAllBySupplierId(Long supplierId) {
        Supplier supplier = supplierService.getById(supplierId);

        return  repository.findAllBySupplier(supplier);
    }

    @Override
    public SupplierCategory save(SupplierCategory supplierCategory) {
        Long supplierId = supplierCategory.getSupplier().getId();
        Supplier supplier = supplierService.getById(supplierId);
        supplierCategory.setSupplier(supplier);
        return repository.save(supplierCategory);
    }

    @Override
    public SupplierCategory update(SupplierCategory supplierCategory) {
        SupplierCategory lastSupplierCategory = getById(supplierCategory.getId());

        lastSupplierCategory.setAddress(supplierCategory.getAddress());
        lastSupplierCategory.setImage(supplierCategory.getImage());
        lastSupplierCategory.setName(supplierCategory.getName());

        Long supplierId = supplierCategory.getSupplier().getId();
        Supplier supplier = supplierService.getById(supplierId);

        lastSupplierCategory.setSupplier(supplier);

        return repository.save(lastSupplierCategory);
    }

    @Override
    public SupplierCategory getAllByName(String name) {

        Optional<SupplierCategory> optional = Optional.ofNullable(repository.findAllByName(name));
        if (optional.isEmpty()) {
            throw new NotFoundException("SupplierCategory Not Found");
        }
        return optional.get();
    }

    @Override
    public SupplierCategory getById(Long id) {
        Optional<SupplierCategory> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new NotFoundException("SupplierCategory Not Found");
        }
        return optional.get();
    }

    @Override
    public List<SupplierCategory> getAll() {
        return (List<SupplierCategory>) repository.findAll();
    }

    @Override
    public Page<SupplierCategory> paging(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }

    @Override
    public List<SupplierCategory> search(List<SearchCriteria> searchCriteria) {
        SupplierCategorySpecifcation supplierCategorySpecifcation=new SupplierCategorySpecifcation();
        searchCriteria.forEach(criteria-> supplierCategorySpecifcation.add(criteria));
        return repository.findAll(supplierCategorySpecifcation);
    }

    @Override
    public Page<SupplierCategory> searchPaging(List<SearchCriteria> searchCriteria, Integer page, Integer size) {
        SupplierCategorySpecifcation supplierCategorySpecifcation=new SupplierCategorySpecifcation();
        searchCriteria.forEach(criteria-> supplierCategorySpecifcation.add(criteria));

        return repository.findAll(supplierCategorySpecifcation, PageRequest.of(page,size ,Sort.by("id").descending()));
    }


}
