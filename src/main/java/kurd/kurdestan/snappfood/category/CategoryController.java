package kurd.kurdestan.snappfood.category;


import lombok.AllArgsConstructor;
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
    public ResponseEntity save(@RequestBody CategoryDTO categoryDTO) {

        Category category = mapper.toCategory(categoryDTO);
        service.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody CategoryDTO categoryDTO) {
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
}
