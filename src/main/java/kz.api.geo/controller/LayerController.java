package kz.api.geo.controller;

import io.swagger.v3.oas.annotations.Operation;
import kz.api.geo.dto.LayersDto;
import kz.api.geo.dto.LayerObjectCountDto;
import kz.api.geo.dto.LayerObjectsInRadiusDto;
import kz.api.geo.dto.LayerOjectCountParamsDto;
import kz.api.geo.dto.LayerObjectsInRadiusParamDto;
import kz.api.geo.external.GeoIntellectFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/layers")
public class LayerController {

    final private GeoIntellectFeignClient geoIntellectFeignClient;

    @Operation(summary = "Get layers")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public LayersDto getLayersList() {
        return geoIntellectFeignClient.getLayersList();
    }

    @Operation(summary = "Get layer object count")
    @RequestMapping(value = "objects-count", method = RequestMethod.POST)
    public LayerObjectCountDto getLayerObjectsCount(
            @RequestBody LayerOjectCountParamsDto layerOjectCountParamsDto
    ) {
        return geoIntellectFeignClient.getLayerObjectsCount(layerOjectCountParamsDto.getLayerId());
    }

    @Operation(summary = "Get layer objects in radius")
    @RequestMapping(value = "objects-in-radius", method = RequestMethod.POST)
    public LayerObjectsInRadiusDto getLayerObjectsInRadius(
            @RequestBody LayerObjectsInRadiusParamDto layerObjectsInRadiusParamDto
    ) {
        return geoIntellectFeignClient.getLayerObjectsInRadius(
                layerObjectsInRadiusParamDto.getLayerId(),
                layerObjectsInRadiusParamDto.getLongitude(),
                layerObjectsInRadiusParamDto.getLatitude(),
                layerObjectsInRadiusParamDto.getRadiusSize()
        );
    }
}
