package kurd.kurdestan.snappfood.bill;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BillServiceImp implements IBillService {
 private final BillRepository repository;


    @Override
    public Bill save(Bill bill) {
        return null;
    }

    @Override
    public List<Bill> getAll() {
        return (List<Bill>) repository.findAll();
    }

    @Override
    public void delete(Long id) {

        getById(id);
        repository.deleteById(id);
    }

    @Override
    public Bill AllPrice(BigDecimal money) {

        return null;
    }

    @Override
    public Bill getById(Long id) {
        Optional<Bill> optional=repository.findById(id);
        if(optional.isEmpty()){
            throw new NotFoundException("Bill Not Found");
        }
        return optional.get();
    }
}
