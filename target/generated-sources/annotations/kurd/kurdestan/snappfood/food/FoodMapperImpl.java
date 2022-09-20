package kurd.kurdestan.snappfood.food;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-20T08:38:05+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.4.1 (Amazon.com Inc.)"
)
@Component
public class FoodMapperImpl implements FoodMapper {

    @Override
    public Food toFood(FoodDTO foodDTO) {
        if ( foodDTO == null ) {
            return null;
        }

        Food food = new Food();

        food.setId( foodDTO.getId() );
        food.setVersion( foodDTO.getVersion() );
        food.setCreatedDate( foodDTO.getCreatedDate() );
        food.setCreatedBy( foodDTO.getCreatedBy() );
        food.setLastModifiedDate( foodDTO.getLastModifiedDate() );
        food.setLastModifiedBy( foodDTO.getLastModifiedBy() );
        food.setName( foodDTO.getName() );
        food.setImage( foodDTO.getImage() );
        food.setDescription( foodDTO.getDescription() );
        food.setSupplierCategory( foodDTO.getSupplierCategory() );

        return food;
    }

    @Override
    public FoodDTO toFoodDTO(Food food) {
        if ( food == null ) {
            return null;
        }

        FoodDTO foodDTO = new FoodDTO();

        foodDTO.setId( food.getId() );
        foodDTO.setVersion( food.getVersion() );
        foodDTO.setCreatedDate( food.getCreatedDate() );
        foodDTO.setCreatedBy( food.getCreatedBy() );
        foodDTO.setLastModifiedDate( food.getLastModifiedDate() );
        foodDTO.setLastModifiedBy( food.getLastModifiedBy() );
        foodDTO.setName( food.getName() );
        foodDTO.setImage( food.getImage() );
        foodDTO.setDescription( food.getDescription() );
        foodDTO.setSupplierCategory( food.getSupplierCategory() );

        return foodDTO;
    }

    @Override
    public List<Food> toFoodList(List<FoodDTO> foodDTOList) {
        if ( foodDTOList == null ) {
            return null;
        }

        List<Food> list = new ArrayList<Food>( foodDTOList.size() );
        for ( FoodDTO foodDTO : foodDTOList ) {
            list.add( toFood( foodDTO ) );
        }

        return list;
    }

    @Override
    public List<FoodDTO> toFoodListDTO(List<Food> foodList) {
        if ( foodList == null ) {
            return null;
        }

        List<FoodDTO> list = new ArrayList<FoodDTO>( foodList.size() );
        for ( Food food : foodList ) {
            list.add( toFoodDTO( food ) );
        }

        return list;
    }
}
