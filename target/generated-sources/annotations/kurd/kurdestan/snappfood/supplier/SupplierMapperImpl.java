package kurd.kurdestan.snappfood.supplier;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-19T13:44:03+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.4.1 (Amazon.com Inc.)"
)
@Component
public class SupplierMapperImpl implements SupplierMapper {

    @Override
    public List<Supplier> toSupplierList(List<SupplierDTO> supplierDTOList) {
        if ( supplierDTOList == null ) {
            return null;
        }

        List<Supplier> list = new ArrayList<Supplier>( supplierDTOList.size() );
        for ( SupplierDTO supplierDTO : supplierDTOList ) {
            list.add( toSupplier( supplierDTO ) );
        }

        return list;
    }

    @Override
    public List<SupplierDTO> toSupplierDTOs(List<Supplier> supplierList) {
        if ( supplierList == null ) {
            return null;
        }

        List<SupplierDTO> list = new ArrayList<SupplierDTO>( supplierList.size() );
        for ( Supplier supplier : supplierList ) {
            list.add( toSupplierDTO( supplier ) );
        }

        return list;
    }

    @Override
    public Supplier toSupplier(SupplierDTO supplierDTO) {
        if ( supplierDTO == null ) {
            return null;
        }

        Supplier supplier = new Supplier();

        supplier.setLocation( convertLocationDtoToLocation( supplierDTO.getLocationDTO() ) );
        supplier.setName( supplierDTO.getName() );
        supplier.setAddress( supplierDTO.getAddress() );
        supplier.setImage( supplierDTO.getImage() );

        return supplier;
    }

    @Override
    public SupplierDTO toSupplierDTO(Supplier supplier) {
        if ( supplier == null ) {
            return null;
        }

        SupplierDTO supplierDTO = new SupplierDTO();

        supplierDTO.setLocationDTO( convertLocationToLocationDTO( supplier.getLocation() ) );
        supplierDTO.setName( supplier.getName() );
        supplierDTO.setLocation( supplier.getLocation() );
        supplierDTO.setAddress( supplier.getAddress() );
        supplierDTO.setImage( supplier.getImage() );

        return supplierDTO;
    }
}
