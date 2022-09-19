package kurd.kurdestan.snappfood.supplier;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LocationDTO {

    @ApiModelProperty(required = true)
    private double lat;
    @ApiModelProperty(required = true)
    private double lang;

}
