package com.example.uptime_service.monitor;

import java.time.Instant;

public record MonitorResponse(
        Long id,
        String name,
        MonitorType type,
        String target,
        int intervalSeconds,
        int timeoutMs,
        int failureThreshold,
        boolean enabled,
        Instant createdAt
) {

    public static MonitorResponse from(Monitor m) {
        return new MonitorResponse(
                m.getId(),
                m.getName(),
                m.getType(),
                m.getTarget(),
                m.getIntervalSeconds(),
                m.getTimeoutMs(),
                m.getFailureThreshold(),
                m.isActive(),
                m.getCreatedAt()
        );
    }
}
