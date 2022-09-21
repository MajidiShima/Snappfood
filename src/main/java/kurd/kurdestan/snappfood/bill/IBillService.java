package kurd.kurdestan.snappfood.bill;


import java.util.List;

public interface IBillService {

    Bill save(Bill bill);
    List<Bill> getAll();
    void delete (Long id);
    Bill getById(Long id);
}
