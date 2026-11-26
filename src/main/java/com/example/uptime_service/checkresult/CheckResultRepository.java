package com.example.uptime_service.checkresult;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckResultRepository extends JpaRepository<CheckResult, Long> {

    List<CheckResult> findByMonitorIdOrderByCheckedAtDesc(Long monitorId, Pageable pageable);

    Optional<CheckResult> findFirstByMonitorIdOrderByCheckedAtDesc(Long monitorId);
}
