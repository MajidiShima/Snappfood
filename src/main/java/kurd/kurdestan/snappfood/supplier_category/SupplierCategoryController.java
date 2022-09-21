package kurd.kurdestan.snappfood.supplier_category;

import kurd.kurdestan.snappfood.common.PagingData;

import kurd.kurdestan.snappfood.common.SearchCriteria;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/supplierCategory")
public class SupplierCategoryController {

    private final ISupplierCategoryService service;
    private final SupplierCategoryMapper mapper;


    @PostMapping("/v1")
    public ResponseEntity <SupplierCategoryDTO>save(@RequestBody SupplierCategoryDTO supplierCategoryDTO){
        SupplierCategory supplierCategory= mapper.toSupplierCategory(supplierCategoryDTO);
        service.save(supplierCategory);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/v1")
    public ResponseEntity <SupplierCategoryDTO> update(@RequestBody SupplierCategoryDTO supplierCategoryDTO){
        SupplierCategory supplierCategory= mapper.toSupplierCategory(supplierCategoryDTO);
        service.update(supplierCategory);
        return ResponseEntity.ok().build();

    }
    @GetMapping("/v1/{id}")
    public ResponseEntity <SupplierCategoryDTO> getById(@PathVariable Long id){
        SupplierCategory supplierCategory=service.getById(id);
        SupplierCategoryDTO supplierCategoryDTO=mapper.toSupplierCategoryDTO(supplierCategory);
        return ResponseEntity.ok(supplierCategoryDTO);
    }

    @GetMapping("/v1")
    public ResponseEntity <List<SupplierCategoryDTO>> getAll(){
        List<SupplierCategory> supplierCategoryList=service.getAll();
        List<SupplierCategoryDTO> supplierCategoryDTOList=mapper.toSupplierCategoryDTOS(supplierCategoryList);
        return ResponseEntity.ok(supplierCategoryDTOList);

    }
    @GetMapping("/v1/get-by-supplier/{supplierId}")
    public ResponseEntity <List<SupplierCategoryDTO>> getAllBySupplierId(@PathVariable Long supplierId){
        List<SupplierCategory> supplierCategoryList=service.getAllBySupplierId(supplierId);
        List<SupplierCategoryDTO> supplierCategoryDTOList=mapper.toSupplierCategoryDTOS(supplierCategoryList);
        return ResponseEntity.ok(supplierCategoryDTOList);
    }

    @GetMapping("/v1/get-by-name/{name}")
    public ResponseEntity <SupplierCategoryDTO> getAllByName(@PathVariable String name){
        SupplierCategory supplierCategory=service.getAllByName(name);
        SupplierCategoryDTO supplierCategoryDTO=mapper.toSupplierCategoryDTO(supplierCategory);
        return ResponseEntity.ok(supplierCategoryDTO);
    }

    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity <PagingData<SupplierCategoryDTO>> paging(@PathVariable Integer page,@PathVariable Integer size){

        Page<SupplierCategory> supplierCategoriesPage=service.paging(page,size);

        int totalPage=supplierCategoriesPage.getTotalPages();

        List<SupplierCategory> data=supplierCategoriesPage.getContent();

        List<SupplierCategoryDTO> supplierCategoryDTOList=mapper.toSupplierCategoryDTOS(data);

        PagingData<SupplierCategoryDTO> pagingData=new PagingData<>(totalPage,page,supplierCategoryDTOList);
        return ResponseEntity.ok(pagingData);

    }

    @GetMapping("/v1/search-page/")
    public ResponseEntity <PagingData<SupplierCategoryDTO>> searchPage(@RequestBody List<SearchCriteria> searchCriteria,Integer page,Integer size){
        Page<SupplierCategory> supplierCategories=service.searchPaging(searchCriteria,page,size);
       int total=supplierCategories.getTotalPages();

        List<SupplierCategory> data=supplierCategories.getContent();

        List<SupplierCategoryDTO> supplierCategoryDTOList=mapper.toSupplierCategoryDTOS(data);

        PagingData<SupplierCategoryDTO> pagingData=new PagingData<>(total,page,supplierCategoryDTOList);
        return ResponseEntity.ok(pagingData);
    }
    @GetMapping("/v1/search")
    public ResponseEntity<List<SupplierCategoryDTO>> search(@RequestBody List<SearchCriteria> searchCriteria){
        List<SupplierCategory> supplierCategoryList=service.search(searchCriteria);
        List<SupplierCategoryDTO> supplierCategoryDTOList=mapper.toSupplierCategoryDTOS(supplierCategoryList);
        return ResponseEntity.ok(supplierCategoryDTOList);

    }
}
