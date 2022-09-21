package kurd.kurdestan.snappfood.bill;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BillMapper {
    Bill toBill(BillDTO billDTO);
    BillDTO toBillDTO(Bill bill);
    List<Bill> toBillList(List<BillDTO> billDTOList);
    List<BillDTO> toBillDTOList(List<Bill> bills);

}
