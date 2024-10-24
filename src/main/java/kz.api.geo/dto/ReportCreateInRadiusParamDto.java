package kz.api.geo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.Max;
import java.math.BigDecimal;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportCreateInRadiusParamDto {

    private List<Integer> layerIds;

    private BigDecimal longitude;

    private BigDecimal latitude;

    @Max(value = 10000, message = "Максимальное значение радиуса 10000") private Integer radiusSize;

    private String name;
}
