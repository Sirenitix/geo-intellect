package kz.api.geo.external;

import kz.api.geo.config.FeignClientConfiguration;
import kz.api.geo.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        value = "geo-intellect",
        url = "${external.url}",
        configuration = FeignClientConfiguration.class
)
public interface GeoIntellectFeignClient {

    @RequestMapping(value = "layers/list", method = RequestMethod.POST)
    ResponseEntity<?> getLayersList();

    @RequestMapping(
            value = "glayer/objects_count",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    ResponseEntity<?> getLayerObjectsCount(@RequestParam("layerid") Integer layerId);


    @RequestMapping(
            value = "glayer/objects_in_radius",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    ResponseEntity<?> getLayerObjectsInRadius(
            @RequestParam("layerid") Integer layerId,
            @RequestParam("xlon") Integer longitude,
            @RequestParam("ylat") Integer latitude,
            @RequestParam("size") Integer size
    );

    @RequestMapping(
            value = "reports/create_in_radius",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    ReportInRadiusDto createReportInRadius(
            @RequestParam("name") String name,
            @RequestParam("layerid") Integer layerId,
            @RequestParam("xlon") Integer longitude,
            @RequestParam("ylat") Integer latitude,
            @RequestParam("size") Integer size
    );

    @RequestMapping(value = "reports/history", method = RequestMethod.POST)
    ReportHistoryDto getReportHistory();

    @RequestMapping(
            value = "reports/get_details",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    ResponseEntity<?> getReportDetail(@RequestParam("uid") String uid);

    @RequestMapping(
            value = "reports/get_image",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    ResponseEntity<?> getReportImage(@RequestParam("uid") String uid);
}
