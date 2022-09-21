package kurd.kurdestan.snappfood.basket_item;


import kurd.kurdestan.snappfood.food.Food;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface IBasketItemService {
BasketItem save(BasketItem basketItem);
List<BasketItem> getAll();
BasketItem getById(Long id);

    List<BasketItem>getAllByFood(Long foodId);
    List<BasketItem>getAllByBasket(Long basketId);



}
