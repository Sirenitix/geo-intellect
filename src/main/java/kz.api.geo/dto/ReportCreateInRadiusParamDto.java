package kz.api.geo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportCreateInRadiusParamDto {

    private Integer layerId;

    private Integer longitude;

    private Integer latitude;

    private Integer radiusSize;

    private String name;
}
