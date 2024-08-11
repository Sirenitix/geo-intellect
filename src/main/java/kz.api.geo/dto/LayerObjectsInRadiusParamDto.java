package kz.api.geo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LayerObjectsInRadiusParamDto {

    private Integer layerId;

    private Integer longitude;

    private Integer latitude;

    private Integer radiusSize;
}
