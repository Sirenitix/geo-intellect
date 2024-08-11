package kz.api.geo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportHistoryDto {
    private String status;
    private boolean success;
    private String message;
    private String details;
    private List<ReportHistoryResult> results;
}
