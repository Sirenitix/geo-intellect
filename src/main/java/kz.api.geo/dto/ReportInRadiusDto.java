package kz.api.geo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportInRadiusDto {
    private String status;
    private Boolean success;
    private String message;
    private String details;
    @JsonProperty("results")
    private ReportInRadiusResults reportInRadiusResults;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class ReportAlias {
    private String language;
    private String alias;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class DemographicStats {
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class Layer {
    @JsonProperty("LayerId")
    private int layerId;
    @JsonProperty("LayerName")
    private String layerName;
    @JsonProperty("LayerUid")
    private Object layerUid;
    @JsonProperty("Editable")
    private Boolean editable;
    @JsonProperty("LayerSchema")
    private List<LayerSchema> layerSchema;
    @JsonProperty("Count")
    private int count;
    @JsonProperty("Objects")
    private List<Object> objects;
    @JsonProperty("IsPay")
    private int isPay;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class LayerSchema {
    private String name;
    private List<ReportAlias> aliases;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class Params {
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class Point {
    private List<Double> coordinates;
    private String type;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class Polygon {
    private List<List<List<Double>>> coordinates;
    private String type;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class ReportContent {
    @JsonProperty("Stats")
    private List<Stat> stats;
    @JsonProperty("Layers")
    private List<Layer> layers;
    @JsonProperty("Values")
    private List<Object> values;
    @JsonProperty("ErrorMessages")
    private List<Object> errorMessages;
    @JsonProperty("DemographicStats")
    private DemographicStats demographicStats;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class ReportMetadata {
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
    private Object details;
    @JsonProperty("Values")
    private Object values;
    @JsonProperty("Params")
    private Params params;
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

