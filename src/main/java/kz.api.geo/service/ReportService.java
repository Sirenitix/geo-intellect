package kz.api.geo.service;

import kz.api.geo.dto.ReportCreateInRadiusParamDto;
import kz.api.geo.dto.ReportDetailDto;
import kz.api.geo.dto.ReportHistoryResult;
import kz.api.geo.dto.ReportInRadiusDto;

import java.security.Principal;
import java.util.List;

public interface ReportService {
    ReportInRadiusDto createReportInRadius(
            ReportCreateInRadiusParamDto createInRadiusParamDto,
            Principal principal
    );

    List<ReportHistoryResult> getReportHistory(Principal principal);

    ReportDetailDto getReportDetail(String uid);
}
