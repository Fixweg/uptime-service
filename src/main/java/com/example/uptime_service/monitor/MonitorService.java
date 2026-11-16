package com.example.uptime_service.monitor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MonitorService {

    private final MonitorRepository repository;

    public MonitorService(MonitorRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Monitor> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Monitor get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Monitor " + id + " nicht gefunden"));
    }

    @Transactional
    public Monitor create(MonitorRequest request) {
        Monitor monitor = new Monitor(
                request.name(),
                request.type(),
                request.target(),
                request.intervalSeconds(),
                request.timeoutMs(),
                request.failureThreshold());
        if (request.enabled() != null) {
            monitor.setActive(request.enabled());
        }
        return repository.save(monitor);
    }

    @Transactional
    public Monitor update(Long id, MonitorRequest request) {
        Monitor monitor = get(id);
        monitor.setName(request.name());
        monitor.setType(request.type());
        monitor.setTarget(request.target());
        monitor.setIntervalSeconds(request.intervalSeconds());
        monitor.setTimeoutMs(request.timeoutMs());
        monitor.setFailureThreshold(request.failureThreshold());
        if (request.enabled() != null) {
            monitor.setActive(request.enabled());
        }

        return monitor;
    }

    @Transactional
    public void delete(Long id) {
        repository.delete(get(id));
    }
}
