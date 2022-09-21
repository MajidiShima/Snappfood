package kurd.kurdestan.snappfood.bill;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-20T19:26:00+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.4.1 (Amazon.com Inc.)"
)
@Component
public class BillMapperImpl implements BillMapper {

    @Override
    public Bill toBill(BillDTO billDTO) {
        if ( billDTO == null ) {
            return null;
        }

        Bill bill = new Bill();

        bill.setId( billDTO.getId() );
        bill.setVersion( billDTO.getVersion() );
        bill.setCreatedDate( billDTO.getCreatedDate() );
        bill.setCreatedBy( billDTO.getCreatedBy() );
        bill.setLastModifiedDate( billDTO.getLastModifiedDate() );
        bill.setLastModifiedBy( billDTO.getLastModifiedBy() );
        bill.setTotalPrice( billDTO.getTotalPrice() );

        return bill;
    }

    @Override
    public BillDTO toBillDTO(Bill bill) {
        if ( bill == null ) {
            return null;
        }

        BillDTO billDTO = new BillDTO();

        billDTO.setId( bill.getId() );
        billDTO.setVersion( bill.getVersion() );
        billDTO.setCreatedDate( bill.getCreatedDate() );
        billDTO.setCreatedBy( bill.getCreatedBy() );
        billDTO.setLastModifiedDate( bill.getLastModifiedDate() );
        billDTO.setLastModifiedBy( bill.getLastModifiedBy() );
        billDTO.setTotalPrice( bill.getTotalPrice() );

        return billDTO;
    }

    @Override
    public List<Bill> toBillList(List<BillDTO> billDTOList) {
        if ( billDTOList == null ) {
            return null;
        }

        List<Bill> list = new ArrayList<Bill>( billDTOList.size() );
        for ( BillDTO billDTO : billDTOList ) {
            list.add( toBill( billDTO ) );
        }

        return list;
    }

    @Override
    public List<BillDTO> toBillDTOList(List<Bill> bills) {
        if ( bills == null ) {
            return null;
        }

        List<BillDTO> list = new ArrayList<BillDTO>( bills.size() );
        for ( Bill bill : bills ) {
            list.add( toBillDTO( bill ) );
        }

        return list;
    }
}
