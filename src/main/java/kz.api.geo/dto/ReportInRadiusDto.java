package kz.api.geo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class ReportInRadiusAlias {
    private String language;
    private String alias;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class Attributes {
    private String name;
    private String address;
    @JsonProperty("Subgroup2")
    private String subgroup2;
    private Double geodist_007;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class DemographicStats {
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class Layer {
    @JsonProperty("LayerId")
    private Integer layerId;
    @JsonProperty("LayerName")
    private String layerName;
    @JsonProperty("LayerUid")
    private java.lang.Object layerUid;
    @JsonProperty("Editable")
    private boolean editable;
    @JsonProperty("LayerSchema")
    private ArrayList<LayerSchema> layerSchema;
    @JsonProperty("Count")
    private Integer count;
    @JsonProperty("Objects")
    private ArrayList<ReportObject> objects;
    @JsonProperty("IsPay")
    private Integer isPay;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class LayerSchema {
    private String name;
    private ArrayList<ReportInRadiusAlias> aliases;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class ReportObject {
    @JsonProperty("Id")
    private Integer id;
    @JsonProperty("Uid")
    private java.lang.Object uid;
    @JsonProperty("Geom")
    private java.lang.Object geom;
    @JsonProperty("Attributes")
    private Attributes attributes;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class Point {
    private ArrayList<Double> coordinates;
    private String type;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class Polygon {
    private ArrayList<ArrayList<ArrayList<Double>>> coordinates;
    private String type;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class ReportContent {
    @JsonProperty("Stats")
    private ArrayList<Stat> stats;
    @JsonProperty("Layers")
    private ArrayList<Layer> layers;
    @JsonProperty("Values")
    private ArrayList<java.lang.Object> values;
    @JsonProperty("ErrorMessages")
    private ArrayList<java.lang.Object> errorMessages;
    @JsonProperty("DemographicStats")
    private DemographicStats demographicStats;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class ReportMetadata {
    @JsonProperty("ToolName")
    private String toolName;
    @JsonProperty("Location")
    private java.lang.Object location;
    @JsonProperty("Area")
    private Double area;
    @JsonProperty("Perimeter")
    private Double perimeter;
    @JsonProperty("Buffer")
    private Double buffer;
    @JsonProperty("Dbg")
    private java.lang.Object dbg;
    @JsonProperty("Details")
    private java.lang.Object details;
    @JsonProperty("Values")
    private java.lang.Object values;
    @JsonProperty("Params")
    private java.lang.Object params;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportInRadiusDto {
    private String status;
    private Boolean success;
    private String message;
    private String details;
    private ReportInRadiusResults results;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class Stat {
    @JsonProperty("Parameter")
    private String parameter;
    @JsonProperty("Value")
    private Double value;
    @JsonProperty("TextRepresentation")
    private String textRepresentation;
    @JsonProperty("Units")
    private String units;
    private String data;
}

