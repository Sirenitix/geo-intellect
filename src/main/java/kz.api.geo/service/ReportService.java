package kz.api.geo.service;

import kz.api.geo.dto.*;
import org.springframework.http.ResponseEntity;

import java.security.Principal;
import java.util.List;

public interface ReportService {
    ReportInRadiusDto createReportInRadius(
            ReportCreateInRadiusParamDto createInRadiusParamDto,
            Principal principal
    );

    List<ReportHistoryResult> getReportHistory(Principal principal);

    ResponseEntity<?> getReportDetail(String uid);

    ResponseEntity<?> getReportImage(String uid);
}
