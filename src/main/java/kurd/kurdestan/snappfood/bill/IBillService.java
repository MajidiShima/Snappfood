package kurd.kurdestan.snappfood.bill;

import java.math.BigDecimal;
import java.util.List;

public interface IBillService {

    Bill save(Bill bill);
    List<Bill> getAll();
    void delete (Long id);
    Bill AllPrice(BigDecimal money);
    Bill getById(Long id);
}
