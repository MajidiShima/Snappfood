package kurd.kurdestan.snappfood.supplier_category;



import kurd.kurdestan.snappfood.supplier.SupplierMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {SupplierMapper.class})
public interface SupplierCategoryMapper {

    SupplierCategory toSupplierCategory(SupplierCategoryDTO supplierCategoryDTO);
    SupplierCategoryDTO toSupplierCategoryDTO(SupplierCategory supplierCategory);
    List<SupplierCategory> toSupplierCategoryList(List<SupplierCategoryDTO> supplierCategoryDTOList);
    List<SupplierCategoryDTO> toSupplierCategoryDTOS(List<SupplierCategory> supplierCategoryList);



}
