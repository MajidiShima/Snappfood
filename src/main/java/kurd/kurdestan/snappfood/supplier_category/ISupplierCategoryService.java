package kurd.kurdestan.snappfood.supplier_category;


import kurd.kurdestan.snappfood.common.SearchCriteria;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ISupplierCategoryService {

    List<SupplierCategory> getAllBySupplierId(Long supplierId);
    SupplierCategory save(SupplierCategory supplierCategory);
    SupplierCategory update(SupplierCategory supplierCategory);
    SupplierCategory getAllByName(String name);
    SupplierCategory getById(Long id);
    List<SupplierCategory> getAll();

    Page<SupplierCategory>paging(Integer page,Integer size);
    List<SupplierCategory> search(List<SearchCriteria> searchCriteria);
    Page<SupplierCategory>searchPaging(List<SearchCriteria> searchCriteria,Integer page,Integer size);
}
