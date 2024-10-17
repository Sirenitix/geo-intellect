package kz.api.geo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import kz.api.geo.config.ZonedDateTimeDeserializer;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportInRadiusResults {
    @JsonProperty("Id")
    private int id;
    @JsonProperty("Uid")
    private String uid;
    @JsonProperty("Recdate")
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime recdate;
    @JsonProperty("Tooltype")
    private String tooltype;
    private Boolean is_shared;
    @JsonProperty("ReportMetadata")
    private ReportMetadata reportMetadata;
    @JsonProperty("Address")
    private String address;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Maket_Uid")
    private String maket_Uid;
    @JsonProperty("ScreenshotUid")
    private String screenshotUid;
    @JsonProperty("ReportContent")
    private ReportContent reportContent;
    @JsonProperty("Point")
    private Point point;
    @JsonProperty("Polyline")
    private Object polyline;
    @JsonProperty("Polygon")
    private Polygon polygon;
    @JsonProperty("PointSymbol")
    private Object pointSymbol;
    @JsonProperty("PolylineSymbol")
    private Object polylineSymbol;
    @JsonProperty("PolygonSymbol")
    private Object polygonSymbol;
    @JsonProperty("Login")
    private String login;
    @JsonProperty("UserId")
    private Integer userId;
    @JsonProperty("SharedToken")
    private String sharedToken;
}
