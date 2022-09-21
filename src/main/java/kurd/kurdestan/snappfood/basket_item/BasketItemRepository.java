package kurd.kurdestan.snappfood.basket_item;

import kurd.kurdestan.snappfood.basket.Basket;
import kurd.kurdestan.snappfood.food.Food;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketItemRepository extends PagingAndSortingRepository<BasketItem , Long> {

    List<BasketItem>findAllByFood(Food food);
    List<BasketItem>findAllByBasket(Basket basket);


}
