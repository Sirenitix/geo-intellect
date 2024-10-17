package kz.api.geo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.Max;
import java.math.BigDecimal;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportCreateInRadiusParamDto {

    private Integer layerId;

    private BigDecimal longitude;

    private BigDecimal latitude;

    @Max(value = 10000, message = "Максимальное значение радиуса 10000") private Integer radiusSize;

    private String name;
}
