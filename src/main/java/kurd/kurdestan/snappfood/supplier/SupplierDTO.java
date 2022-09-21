package kurd.kurdestan.snappfood.supplier;


import io.swagger.annotations.ApiModelProperty;
import kurd.kurdestan.snappfood.category.CategoryDTO;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;


@Data
public class SupplierDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String name;
    @ApiModelProperty(required = false,hidden = false)
    private Point<G2D> location;
    @ApiModelProperty(required = false,hidden = false)
    private String address;
    @ApiModelProperty(required = false,hidden = false)
    private String image;
    @ApiModelProperty(required = false,hidden = false)
    private CategoryDTO categories;
    @ApiModelProperty(required = true)
    private LocationDTO locationDTO;



}
