package kurd.kurdestan.snappfood.supplier_category;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-19T13:44:02+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.4.1 (Amazon.com Inc.)"
)
@Component
public class SupplierCategoryMapperImpl implements SupplierCategoryMapper {

    @Override
    public SupplierCategory toSupplierCategory(SupplierCategoryDTO supplierCategoryDTO) {
        if ( supplierCategoryDTO == null ) {
            return null;
        }

        SupplierCategory supplierCategory = new SupplierCategory();

        supplierCategory.setId( supplierCategoryDTO.getId() );
        supplierCategory.setVersion( supplierCategoryDTO.getVersion() );
        supplierCategory.setCreatedDate( supplierCategoryDTO.getCreatedDate() );
        supplierCategory.setCreatedBy( supplierCategoryDTO.getCreatedBy() );
        supplierCategory.setLastModifiedDate( supplierCategoryDTO.getLastModifiedDate() );
        supplierCategory.setLastModifiedBy( supplierCategoryDTO.getLastModifiedBy() );
        supplierCategory.setName( supplierCategoryDTO.getName() );
        supplierCategory.setAddress( supplierCategoryDTO.getAddress() );
        supplierCategory.setSupplier( supplierCategoryDTO.getSupplier() );

        return supplierCategory;
    }

    @Override
    public SupplierCategoryDTO toSupplierCategoryDTO(SupplierCategory supplierCategory) {
        if ( supplierCategory == null ) {
            return null;
        }

        SupplierCategoryDTO supplierCategoryDTO = new SupplierCategoryDTO();

        supplierCategoryDTO.setId( supplierCategory.getId() );
        supplierCategoryDTO.setVersion( supplierCategory.getVersion() );
        supplierCategoryDTO.setCreatedDate( supplierCategory.getCreatedDate() );
        supplierCategoryDTO.setCreatedBy( supplierCategory.getCreatedBy() );
        supplierCategoryDTO.setLastModifiedDate( supplierCategory.getLastModifiedDate() );
        supplierCategoryDTO.setLastModifiedBy( supplierCategory.getLastModifiedBy() );
        supplierCategoryDTO.setName( supplierCategory.getName() );
        supplierCategoryDTO.setAddress( supplierCategory.getAddress() );
        supplierCategoryDTO.setSupplier( supplierCategory.getSupplier() );

        return supplierCategoryDTO;
    }

    @Override
    public List<SupplierCategory> toSupplierCategoryList(List<SupplierCategoryDTO> supplierCategoryDTOList) {
        if ( supplierCategoryDTOList == null ) {
            return null;
        }

        List<SupplierCategory> list = new ArrayList<SupplierCategory>( supplierCategoryDTOList.size() );
        for ( SupplierCategoryDTO supplierCategoryDTO : supplierCategoryDTOList ) {
            list.add( toSupplierCategory( supplierCategoryDTO ) );
        }

        return list;
    }

    @Override
    public List<SupplierCategoryDTO> toSupplierCategoryDTOS(List<SupplierCategory> supplierCategoryList) {
        if ( supplierCategoryList == null ) {
            return null;
        }

        List<SupplierCategoryDTO> list = new ArrayList<SupplierCategoryDTO>( supplierCategoryList.size() );
        for ( SupplierCategory supplierCategory : supplierCategoryList ) {
            list.add( toSupplierCategoryDTO( supplierCategory ) );
        }

        return list;
    }
}
