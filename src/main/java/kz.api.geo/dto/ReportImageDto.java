package kz.api.geo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportImageDto {
    private String status;
    private Boolean success;
    private String message;
    private String details;
    private String results;
}


