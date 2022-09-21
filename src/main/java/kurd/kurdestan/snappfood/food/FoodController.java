package kurd.kurdestan.snappfood.food;


import kurd.kurdestan.snappfood.common.SearchCriteria;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/food")
public class FoodController {
    private final IFoodService service;
    private FoodMapper mapper;

    @PostMapping("/v1")
    public ResponseEntity<FoodDTO> save(@RequestBody FoodDTO foodDTO) {
        Food food = mapper.toFood(foodDTO);
        service.save(food);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity<FoodDTO> update(@RequestBody FoodDTO foodDTO) {
        Food food = mapper.toFood(foodDTO);
        service.update(food);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<FoodDTO> getById(@PathVariable Long id) {
        Food food = service.getById(id);
        FoodDTO foodDTO = mapper.toFoodDTO(food);
        return ResponseEntity.ok(foodDTO);
    }

    @GetMapping("/v1/get-by-name/{name}")
    public ResponseEntity<FoodDTO> getAllByName(@PathVariable String name) {
        Food food = service.getAllByName(name);
        FoodDTO foodDTO = mapper.toFoodDTO(food);
        return ResponseEntity.ok(foodDTO);
    }
    @GetMapping("/v1/search")
    public ResponseEntity<List<FoodDTO>> search(@RequestBody List<SearchCriteria> searchCriteria){
        List<Food> foodList=service.search(searchCriteria);
        List<FoodDTO> foodDTOS=mapper.toFoodListDTO(foodList);
        return ResponseEntity.ok(foodDTOS);
    }

    @DeleteMapping("/delete-by-id/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.deleteBYId(id);
        return ResponseEntity.ok().build();
    }

}
