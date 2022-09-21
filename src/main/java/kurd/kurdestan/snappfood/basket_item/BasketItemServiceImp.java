package kurd.kurdestan.snappfood.basket_item;


import kurd.kurdestan.snappfood.basket.Basket;
import kurd.kurdestan.snappfood.basket.IBasketService;
import kurd.kurdestan.snappfood.food.Food;
import kurd.kurdestan.snappfood.food.IFoodService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BasketItemServiceImp implements IBasketItemService {

    private final BasketItemRepository repository;
    private final IBasketService basketService;
    private final IFoodService foodService;


    @Override
    public BasketItem save(BasketItem basketItem) {
        Long foodId=basketItem.getFood().getId();
        Long basketId=basketItem.getBasket().getId();
        Basket basket=basketService.getById(basketId);
        Food food=foodService.getById(foodId);
        basketItem.setBasket(basket);
        basketItem.setFood(food);

        return repository.save(basketItem);
    }

    @Override
    public BasketItem add(Long id) {
        BasketItem basketItem=getById(id);
        basketItem.setCount(basketItem.getCount()+1);
        return repository.save(basketItem);
    }

    @Override
    public BasketItem min(Long id) {
        BasketItem basketItem=getById(id);
        basketItem.setCount(basketItem.getCount()-1);
        return repository.save(basketItem);
    }

    @Override
    public void delete(Long byId) {

        getById(byId);
        repository.deleteById(byId);
    }

    @Override
    public List<BasketItem> getAll() {
      return (List<BasketItem>) repository.findAll();
    }

    @Override
    public BasketItem getById(Long id) {
        Optional<BasketItem> optional=repository.findById(id);
        if(optional.isEmpty()){
            throw new NotFoundException("BasketItem Not Found");
        }
        return optional.get();
    }

    @Override
    public List<BasketItem> getAllByFood(Long foodId) {
       Food food=foodService.getById(foodId);
       return repository.findAllByFood(food);
    }

    @Override
    public List<BasketItem> getAllByBasket(Long basketId) {
        Basket basket=basketService.getById(basketId);
        return repository.findAllByBasket(basket);
    }
}
