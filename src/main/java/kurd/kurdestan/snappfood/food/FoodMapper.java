package kurd.kurdestan.snappfood.food;


import kurd.kurdestan.snappfood.supplier_category.SupplierCategoryMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {SupplierCategoryMapper.class})

public interface FoodMapper {

    Food toFood(FoodDTO foodDTO);
    FoodDTO toFoodDTO(Food food);
    List<Food> toFoodList(List<FoodDTO> foodDTOList);
    List<FoodDTO> toFoodListDTO(List<Food> foodList);



}
