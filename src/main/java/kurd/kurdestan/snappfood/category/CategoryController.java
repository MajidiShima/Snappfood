package kurd.kurdestan.snappfood.category;


import kurd.kurdestan.snappfood.common.PagingData;
import kurd.kurdestan.snappfood.common.SearchCriteria;
import kurd.kurdestan.snappfood.supplier_category.SupplierCategory;
import kurd.kurdestan.snappfood.supplier_category.SupplierCategoryDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/category/")
public class CategoryController {

    private final ICategoryService service;
    private final CategoryMapper mapper;

    @PostMapping("/v1")
    public ResponseEntity<CategoryDTO> save(@RequestBody CategoryDTO categoryDTO) {
        Category category = mapper.toCategory(categoryDTO);
        service.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity <CategoryDTO> update(@RequestBody CategoryDTO categoryDTO) {
        Category category = mapper.toCategory(categoryDTO);
        service.update(category);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1")
    public ResponseEntity<List<CategoryDTO>> getAll() {
        List<Category> category = service.getAll();
        List<CategoryDTO> list = mapper.toCategoryDTOS(category);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/v1/title/{title}")
    public ResponseEntity<CategoryDTO> getAllByTitle(@PathVariable String title){
        Category category=service.getAllByTitle(title);
        CategoryDTO categoryDTO=mapper.toCategoryDTO(category);
        return ResponseEntity.ok(categoryDTO);
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<CategoryDTO> getById(@PathVariable Long id) {
        Category category= service.getById(id);
      CategoryDTO categoryDTO = mapper.toCategoryDTO(category);
        return ResponseEntity.ok(categoryDTO);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.deleteById(id);
       return ResponseEntity.ok().build();
    }
    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity <PagingData<CategoryDTO>> paging(@PathVariable Integer page, @PathVariable Integer size){
        Page<Category> categoriesPage=service.paging(page,size);
        int totalPage=categoriesPage.getTotalPages();
        List<Category> data=categoriesPage.getContent();
        List<CategoryDTO> supplierCategoryDTOList=mapper.toCategoryDTOS(data);
        PagingData<CategoryDTO> pagingData=new PagingData<>(totalPage,page,supplierCategoryDTOList);
        return ResponseEntity.ok(pagingData);
    }

    @GetMapping("/v1/search-page/")
    public ResponseEntity <PagingData<CategoryDTO>> searchPage(@RequestBody List<SearchCriteria> searchCriteria, Integer page, Integer size){
        Page<Category> categories=service.searchPaging(searchCriteria,page,size);
        int total=categories.getTotalPages();
        List<Category> data=categories.getContent();
        List<CategoryDTO> categoryDTOList=mapper.toCategoryDTOS(data);
        PagingData<CategoryDTO> pagingData=new PagingData<>(total,page,categoryDTOList);
        return ResponseEntity.ok(pagingData);
    }
    @GetMapping("/v1/search")
    public ResponseEntity<List<CategoryDTO>> search(@RequestBody List<SearchCriteria> searchCriteria){
        List<Category> CategoryList=service.search(searchCriteria);
        List<CategoryDTO> CategoryDTOList=mapper.toCategoryDTOS(CategoryList);
        return ResponseEntity.ok(CategoryDTOList);

    }






}
