package kz.api.geo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LayerObjectsInRadiusDto {
    private String status;
    private boolean success;
    private String message;
    private String details;
    @JsonProperty("results")
    private List<ObjectsInRadiusResult> objectsInRadiusResult;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class ObjectsInRadiusResult {
    private Geometry geometry;
    private Properties properties;
    private String id;
    private String type;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class Properties {
    private int id;
    private String name;
    private String address;
    @JsonProperty("Subgroup2")
    private String subgroup2;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class Geometry {
    private List<Double> coordinates;
    private String type;
}