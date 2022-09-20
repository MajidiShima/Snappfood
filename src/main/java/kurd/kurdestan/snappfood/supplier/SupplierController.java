package kurd.kurdestan.snappfood.supplier;

import kurd.kurdestan.snappfood.common.PagingData;
import kurd.kurdestan.snappfood.common.SearchCriteria;
import lombok.AllArgsConstructor;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometries;
import org.geolatte.geom.Point;
import org.geolatte.geom.crs.CoordinateReferenceSystems;
import org.springframework.data.domain.Page;
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
        Supplier supplier = mapper.toSupplier(supplierDTO);
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
        List<Supplier> suppliers = supplierService.getALL();
        List<SupplierDTO> list = mapper.toSupplierDTOs(suppliers);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/v1/name/{name}")
    public ResponseEntity<SupplierDTO> getAllByName(@PathVariable String name) {
        Supplier supplier = supplierService.getAllByName(name);
        SupplierDTO supplierDTO = mapper.toSupplierDTO(supplier);
        return ResponseEntity.ok(supplierDTO);
    }

    @GetMapping("/v1/get-by-category/{id}")
    public ResponseEntity<List<SupplierDTO>> getAllByCategoryId(@PathVariable Long id) {

        List<Supplier> suppliers = supplierService.getAllByCategoryId(id);
        List<SupplierDTO> supplierDTOList = mapper.toSupplierDTOs(suppliers);
        return ResponseEntity.ok(supplierDTOList);
    }

    @GetMapping("/v1/get-by-Id/{id}")
    public ResponseEntity<SupplierDTO> getAllById(@PathVariable String id) {
        Supplier supplier = supplierService.getAllByName(id);
        SupplierDTO supplierDTO = mapper.toSupplierDTO(supplier);
        return ResponseEntity.ok(supplierDTO);
    }

    @GetMapping("/v1/get-nearest-point/{lat}/{lang}/{distance}")
    public ResponseEntity getNearest(
            @PathVariable("lat") double lat,
            @PathVariable("lang") double lang,
            @PathVariable("distance") double distance) {
        Point<G2D> candidPoint = Geometries.mkPoint(new G2D(lat, lang), CoordinateReferenceSystems.WGS84);
        List<Supplier> suppliers = supplierService.findNearest(candidPoint, distance);
        List<SupplierDTO> supplierDTOS = mapper.toSupplierDTOs(suppliers);
        return ResponseEntity.ok(supplierDTOS);
    }

    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity <PagingData<SupplierDTO>> paging(@PathVariable Integer page, @PathVariable Integer size){
        Page<Supplier> suppliers=supplierService.paging(page,size);
        int totalPage=suppliers.getTotalPages();
        List<Supplier> data=suppliers.getContent();
        List<SupplierDTO> supplierDTOList=mapper.toSupplierDTOs(data);
        PagingData<SupplierDTO> pagingData=new PagingData<>(totalPage,page,supplierDTOList);
        return ResponseEntity.ok(pagingData);
    }

    @GetMapping("/v1/search-page/")
    public ResponseEntity <PagingData<SupplierDTO>> searchPage(@RequestBody List<SearchCriteria> searchCriteria, Integer page, Integer size){
        Page<Supplier> categories=supplierService.searchPaging(searchCriteria,page,size);
        int total=categories.getTotalPages();
        List<Supplier> data=categories.getContent();
        List<SupplierDTO> supplierDTOList=mapper.toSupplierDTOs(data);
        PagingData<SupplierDTO> pagingData=new PagingData<>(total,page,supplierDTOList);
        return ResponseEntity.ok(pagingData);
    }
    @GetMapping("/v1/search")
    public ResponseEntity<List<SupplierDTO>> search(@RequestBody List<SearchCriteria> searchCriteria){
        List<Supplier> supplierList=supplierService.search(searchCriteria);
        List<SupplierDTO> supplierDTOList=mapper.toSupplierDTOs(supplierList);
        return ResponseEntity.ok(supplierDTOList);

    }

}
