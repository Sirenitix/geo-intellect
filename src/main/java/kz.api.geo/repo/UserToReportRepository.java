package kz.api.geo.repo;

import kz.api.geo.entity.UserToReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserToReportRepository extends JpaRepository<UserToReport, Integer> {
    List<UserToReport> findAllByUserId(Long userId);
}
