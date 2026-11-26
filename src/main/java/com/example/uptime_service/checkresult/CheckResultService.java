package com.example.uptime_service.checkresult;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.uptime_service.monitor.MonitorService;

@Service
public class CheckResultService {

    private final CheckResultRepository repository;
    private final MonitorService monitorService;

    public CheckResultService(CheckResultRepository repository, MonitorService monitorService) {
        this.repository = repository;
        this.monitorService = monitorService;
    }

    public CheckResult record(CheckResult result) {
        return repository.save(result);
    }

    public List<CheckResult> latest(Long monitorId, int limit) {
        monitorService.get(monitorId); // wirft deinen 404, wenn der Monitor fehlt
        return repository.findByMonitorIdOrderByCheckedAtDesc(monitorId, PageRequest.of(0, limit));
    }
}
