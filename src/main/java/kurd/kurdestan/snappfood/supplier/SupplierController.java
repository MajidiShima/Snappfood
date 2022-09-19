package kurd.kurdestan.snappfood.supplier;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/supplier")
public class SupplierController {
    private final ISupplierService supplierService;
    private SupplierMapper mapper;


    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody SupplierDTO supplierDTO) {
        Supplier  supplier = mapper.toSupplier(supplierDTO);
        supplierService.save(supplier);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody SupplierDTO supplierDTO) {
        Supplier supplier = mapper.toSupplier(supplierDTO);
        supplierService.update(supplier);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1")
    public ResponseEntity<List<SupplierDTO>> getAll() {
        List<Supplier> suppliers =supplierService.getALL();
        List<SupplierDTO> list = mapper.toSupplierDTOs(suppliers);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/v1/title/{name}")
    public ResponseEntity<SupplierDTO> getAllByName(@PathVariable String name ){
        Supplier supplier=supplierService.getAllByName(name);
        SupplierDTO supplierDTO=mapper.toSupplierDTO(supplier);
        return ResponseEntity.ok(supplierDTO);
    }

    // TODO: 9/18/2022
    @GetMapping("/v1/get-by-category/{id}")
    public ResponseEntity <List<SupplierDTO>>getAllByCategoryId(@PathVariable Long id){

       List<Supplier> suppliers= supplierService.getAllByCategoryId(id);
       List<SupplierDTO> supplierDTOList=mapper.toSupplierDTOs(suppliers);
        return ResponseEntity.ok(supplierDTOList);
    }



}
