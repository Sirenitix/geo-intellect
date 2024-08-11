package kz.api.geo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LayersDto {
    private String status;
    private Boolean success;
    private String message;
    private String details;
    @JsonProperty("results")
    private List<Result> layersResults;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class Alias {
    private String language;
    private String alias;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class Result {
    private Integer id;
    private String name;
    private String type;
    private String layers;
    private String groupType;
    private Integer groupIdForMain;
    private String groupNameForMain;
    private String subGroupName;
    private Integer subGroupId;
    private Integer groupIdForSub;
    private String groupNameForSub;
    private List<Integer> listTerra;
    private List<Schema> schema;
    private Boolean hasTimeline;
    private List<Integer> timelineYears;
    private Boolean hasTimelineWithDates;
    private String timelineWithDatesField;
    private String provider;
    private Integer is_pay;
    private Integer has_city_ids;
    private Integer editable;
    private Integer ordering;
    private Integer origin_id;
    private List<String> tags;
    private List<Object> children;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class Schema {
    private String name;
    private List<Alias> aliases;
}

