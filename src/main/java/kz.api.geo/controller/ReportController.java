package kz.api.geo.controller;

import io.swagger.v3.oas.annotations.Operation;
import kz.api.geo.dto.*;
import kz.api.geo.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
            @Valid @RequestBody ReportCreateInRadiusParamDto createInRadiusParamDto,
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
    public ResponseEntity<?> getReportDetail(@RequestParam String uid) {
        return reportService.getReportDetail(uid);
    }

    @Operation(summary = "Get report image")
    @RequestMapping(value = "report-image", method = RequestMethod.POST)
    public ResponseEntity<?> getReportImage(@RequestParam String uid) {
        return reportService.getReportImage(uid);
    }
}
