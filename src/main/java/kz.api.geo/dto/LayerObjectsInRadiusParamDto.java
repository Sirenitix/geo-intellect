package kz.api.geo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LayerObjectsInRadiusParamDto {

    private Integer layerId;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private Integer radiusSize;
}
