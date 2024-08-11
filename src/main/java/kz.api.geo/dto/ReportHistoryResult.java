package kz.api.geo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportHistoryResult {
    @JsonProperty("Uid")
    public String uid;
    @JsonProperty("Recdate")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public LocalDateTime recdate;
    @JsonProperty("Name")
    public String name;
}
