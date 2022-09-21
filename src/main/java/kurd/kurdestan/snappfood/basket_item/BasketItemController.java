package kurd.kurdestan.snappfood.basket_item;


import kurd.kurdestan.snappfood.basket.Basket;
import kurd.kurdestan.snappfood.basket.BasketDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor

public class BasketItemController {

    private final IBasketItemService basketItemService;
    private BasketItemMapper mapper;

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody BasketItemDTO basketItemDTO){
        BasketItem basketItem=mapper.toBasketItem(basketItemDTO);
        basketItemService.save(basketItem);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/add/{id}")
    public ResponseEntity<BasketDTO> add(@PathVariable Long id) {
        BasketItemDTO basketItem = mapper.toBasketItemDTO(basketItemService.add(id));
        return ResponseEntity.ok().build();
    }
    @PutMapping("/min/{id}")
    public ResponseEntity<BasketDTO> min(@PathVariable Long id){
        BasketItemDTO basketItemDTO=mapper.toBasketItemDTO(basketItemService.min(id));
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        basketItemService.delete(id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/v1")
    public ResponseEntity <List<BasketItemDTO>> getAll(){
        List<BasketItem> basketList=basketItemService.getAll();
        List<BasketItemDTO> basketDTOS=mapper.toBasketItemListDTO(basketList);
        return ResponseEntity.ok(basketDTOS);
    }

    @GetMapping("/v1/get-by-food/{foodId}")
    public ResponseEntity <List<BasketItemDTO>> getAllByFood(@PathVariable Long foodId){
        List<BasketItem> baskets=basketItemService.getAllByFood(foodId);
        List<BasketItemDTO> basketDTOList1=mapper.toBasketItemListDTO(baskets);
        return ResponseEntity.ok(basketDTOList1);
    }
    @GetMapping("/v1/get-by-basket/{basketId}")
    public ResponseEntity <List<BasketItemDTO>> getAllByBasket(@PathVariable Long basketId) {
        List<BasketItem> baskets = basketItemService.getAllByFood(basketId);
        List<BasketItemDTO> basketDTOList1 = mapper.toBasketItemListDTO(baskets);
        return ResponseEntity.ok(basketDTOList1);
    }
}

