package kz.api.geo.external;

import kz.api.geo.config.FeignClientConfiguration;
import kz.api.geo.dto.LayersDto;
import kz.api.geo.dto.LayerObjectsInRadiusDto;
import kz.api.geo.dto.LayerObjectCountDto;
import kz.api.geo.dto.ReportInRadiusDto;
import kz.api.geo.dto.ReportHistoryDto;
import kz.api.geo.dto.ReportDetailDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
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
    LayersDto getLayersList();

    @RequestMapping(
            value = "glayer/objects_count",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    LayerObjectCountDto getLayerObjectsCount(@RequestParam("layerid") Integer layerId);


    @RequestMapping(
            value = "glayer/objects_in_radius",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    LayerObjectsInRadiusDto getLayerObjectsInRadius(
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
    ReportDetailDto getReportDetail(@RequestParam("uid") String uid);
}
