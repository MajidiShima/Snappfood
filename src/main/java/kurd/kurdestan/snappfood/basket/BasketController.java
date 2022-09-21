package kurd.kurdestan.snappfood.basket;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/Basket/")
public class BasketController {
     private final IBasketService basketService;
     private BasketMapper mapper;

  @PostMapping("/v1")
  public ResponseEntity<BasketDTO> save(@RequestBody BasketDTO basketDTO){
      Basket basket=mapper.toBasket(basketDTO);
      basketService.save(basket);
      return ResponseEntity.status(HttpStatus.CREATED).build();
  }
  @PutMapping("/v1")
    public ResponseEntity<BasketDTO>update(@RequestBody BasketDTO basketDTO ){
      Basket basket=mapper.toBasket(basketDTO);
      basketService.update(basket);
      return ResponseEntity.ok().build();
  }
  @GetMapping("/v1")
    public ResponseEntity <List<BasketDTO>> getAll(){
      List<Basket> basketList=basketService.getAll();
      List<BasketDTO> basketDTOS=mapper.toBasketDTOS(basketList);
      return ResponseEntity.ok(basketDTOS);
  }
    @GetMapping("/v1/get-by-Supplier/{supplierId}")
    public ResponseEntity <List<BasketDTO>> getAllBySupplier(@PathVariable Long supplierId){
        List<Basket> baskets=basketService.getAllBySupplier(supplierId);
        List<BasketDTO> basketDTOList1=mapper.toBasketDTOS(baskets);
        return ResponseEntity.ok(basketDTOList1);
    }
    @GetMapping("/v1/get-by-address/{addressId}")
    public ResponseEntity <List<BasketDTO>> getAllByAddress(@PathVariable Long addressId){
      List<Basket> baskets1=basketService.getAllByAddress(addressId);
      List<BasketDTO> basketDTOList=mapper.toBasketDTOS(baskets1);
      return ResponseEntity.ok(basketDTOList);

    }
    @GetMapping("/v1/get-by-address-User/{userId}")
    public ResponseEntity <List<BasketDTO>> getAllByAddress_user(@PathVariable Long userId) {
        List<Basket> baskets1=basketService.getAllByAddress_User(userId);
        List<BasketDTO>basketDTOList2=mapper.toBasketDTOS(baskets1);
        return ResponseEntity.ok(basketDTOList2);
    }

    @GetMapping("/v1/get-by-supplier-category/{categoryId}")
    public ResponseEntity <List<BasketDTO>> getAllBySupplier_Category(@PathVariable Long categoryId) {
        List<Basket> basket=basketService.getAllBySupplier_Category(categoryId);
        List<BasketDTO>basketDOList2=mapper.toBasketDTOS(basket);
        return ResponseEntity.ok(basketDOList2);
    }

    @GetMapping("/v1/get-by-supplier-SupplierCategories/{supplierCategoriesId}")
    public ResponseEntity <List<BasketDTO>> getAllBySupplier_SupplierCategories(@PathVariable Long supplierCategoriesId) {

        List<Basket> basket2 = basketService.getAllBySupplier_SupplierCategories(supplierCategoriesId);
        List<BasketDTO> basketDOList3 = mapper.toBasketDTOS(basket2);
        return ResponseEntity.ok(basketDOList3);
    }


  }

