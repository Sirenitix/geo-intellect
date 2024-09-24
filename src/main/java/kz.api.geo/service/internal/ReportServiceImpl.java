package kz.api.geo.service.internal;

import kz.api.geo.dto.*;
import kz.api.geo.entity.UserToReport;
import kz.api.geo.external.GeoIntellectFeignClient;
import kz.api.geo.repo.UserRepository;
import kz.api.geo.repo.UserToReportRepository;
import kz.api.geo.service.ReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    final private GeoIntellectFeignClient geoIntellectFeignClient;
    final private UserToReportRepository userToReportRepository;
    final private UserRepository userRepository;

    public ReportInRadiusDto createReportInRadius(
            ReportCreateInRadiusParamDto createInRadiusParamDto,
            Principal principal
    ) {
        var reportInRadius = geoIntellectFeignClient.createReportInRadius(
                createInRadiusParamDto.getName(),
                createInRadiusParamDto.getLayerId(),
                createInRadiusParamDto.getLongitude(),
                createInRadiusParamDto.getLatitude(),
                createInRadiusParamDto.getRadiusSize()

        );

        var user = userRepository.findByUsername(principal.getName()).orElseThrow();


        userToReportRepository.save(
                UserToReport.builder()
                        .userId(user.getId())
                        .reportId(reportInRadius.getReportInRadiusResults().getUid())
                        .build()
        );

        return reportInRadius;
    }

    public List<ReportHistoryResult> getReportHistory(Principal principal) {

        var reportHistory = geoIntellectFeignClient.getReportHistory();

        var user = userRepository
                .findByUsername(principal.getName())
                .orElseThrow();

        var reportsOfUser = userToReportRepository
                .findAllByUserId(user.getId())
                .stream()
                .map(UserToReport::getReportId)
                .toList();

        return reportHistory.getResults()
                .stream()
                .filter(report -> reportsOfUser.contains(report.uid))
                .toList();
    }

    public ResponseEntity<?> getReportDetail(String uid) {
        return geoIntellectFeignClient.getReportDetail(uid);
    }

    @Override
    public ResponseEntity<?> getReportImage(String uid) {
        return geoIntellectFeignClient.getReportImage(uid);
    }
}
