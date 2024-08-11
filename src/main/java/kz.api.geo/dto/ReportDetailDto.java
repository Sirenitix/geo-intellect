package kz.api.geo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportDetailDto {
    private String status;
    private Boolean success;
    private String message;
    private String details;
    private ReportDetailResults results;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class ReportDetailDemographicStats {
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class ReportDetailParams {
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class ReportDetailPoint {
    private List<Double> coordinates;
    private String type;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class ReportDetailPolygon {
    private List<List<List<Double>>> coordinates;
    private String type;
}

@Data

@JsonIgnoreProperties(ignoreUnknown = true)
class ReportDetailReportContent {
    @JsonProperty("Stats")
    private List<Object> stats;
    @JsonProperty("Layers")
    private List<Object> layers;
    @JsonProperty("Values")
    private List<Object> values;
    @JsonProperty("ErrorMessages")
    private List<Object> errorMessages;
    @JsonProperty("DemographicStats")
    private ReportDetailDemographicStats demographicStats;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class ReportDetailReportMetadata {
    @JsonProperty("ToolName")
    private String toolName;
    @JsonProperty("Location")
    private Object location;
    @JsonProperty("Area")
    private Double area;
    @JsonProperty("Perimeter")
    private Double perimeter;
    @JsonProperty("Buffer")
    private Double buffer;
    @JsonProperty("Dbg")
    private Object dbg;
    @JsonProperty("Details")
    private String details;
    @JsonProperty("Values")
    private Object values;
    @JsonProperty("Params")
    private ReportDetailParams params;
}

@Data

@JsonIgnoreProperties(ignoreUnknown = true)
class ReportDetailResults {
    @JsonProperty("Id")
    private Integer id;
    @JsonProperty("Uid")
    private String uid;
    @JsonProperty("Recdate")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime recdate;
    @JsonProperty("Tooltype")
    private String tooltype;
    private Boolean is_shared;
    @JsonProperty("ReportMetadata")
    private ReportDetailReportMetadata reportMetadata;
    @JsonProperty("Address")
    private String address;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Maket_Uid")
    private String maket_Uid;
    @JsonProperty("ScreenshotUid")
    private String screenshotUid;
    @JsonProperty("ReportContent")
    private ReportDetailReportContent reportContent;
    @JsonProperty("Point")
    private ReportDetailPoint point;
    @JsonProperty("Polyline")
    private Object polyline;
    @JsonProperty("Polygon")
    private ReportDetailPolygon polygon;
    @JsonProperty("PointSymbol")
    private String pointSymbol;
    @JsonProperty("PolylineSymbol")
    private String polylineSymbol;
    @JsonProperty("PolygonSymbol")
    private String polygonSymbol;
    @JsonProperty("Login")
    private String login;
    @JsonProperty("UserId")
    private Integer userId;
    @JsonProperty("SharedToken")
    private Object sharedToken;
}

