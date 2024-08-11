package kz.api.geo.controller;

import io.swagger.v3.oas.annotations.Operation;
import kz.api.geo.dto.ReportCreateInRadiusParamDto;
import kz.api.geo.dto.ReportDetailDto;
import kz.api.geo.dto.ReportHistoryResult;
import kz.api.geo.dto.ReportInRadiusDto;
import kz.api.geo.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
public class ReportController {

    final private ReportService reportService;

    @Operation(summary = "Create report in radius")
    @RequestMapping(value = "create-in-radius", method = RequestMethod.POST)
    public ReportInRadiusDto createReportInRadius(
            @RequestBody ReportCreateInRadiusParamDto createInRadiusParamDto,
            Principal principal
    ) {
        return reportService.createReportInRadius(
                createInRadiusParamDto,
                principal
        );
    }

    @Operation(summary = "Create report history")
    @RequestMapping(value = "report-history", method = RequestMethod.POST)
    public List<ReportHistoryResult> getReportHistory(Principal principal) {
        return reportService.getReportHistory(principal);
    }

    @Operation(summary = "Get report history detail")
    @RequestMapping(value = "report-detail", method = RequestMethod.POST)
    public ReportDetailDto getReportDetail(@RequestParam String uid) {
        return reportService.getReportDetail(uid);
    }
}
