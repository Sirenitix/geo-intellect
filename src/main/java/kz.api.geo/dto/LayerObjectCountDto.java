package kz.api.geo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LayerObjectCountDto {
    public String status;
    public Boolean success;
    public String message;
    public String details;
    public Integer results;
}
