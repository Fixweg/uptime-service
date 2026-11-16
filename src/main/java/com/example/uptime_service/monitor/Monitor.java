package com.example.uptime_service.monitor;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "monitor")
public class Monitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MonitorType type;

    @Column(nullable = false)
    private String target;

    @Column(nullable = false)
    private int intervalSeconds;

    @Column(nullable = false)
    private int timeoutMs;

    @Column(nullable = false)
    private int failureThreshold;

    @Column(nullable = false)
    private boolean active = true;

    @Column(nullable = false, updatable = false)
    private Instant createdAt = Instant.now();

    // JPA needs contructor without parameters
    protected Monitor() {
    }

    public Monitor(String name, MonitorType type, String target,
                   int intervalSeconds, int timeoutMs, int failureThreshold) {
        this.name = name;
        this.type = type;
        this.target = target;
        this.intervalSeconds = intervalSeconds;
        this.timeoutMs = timeoutMs;
        this.failureThreshold = failureThreshold;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public MonitorType getType() { return type; }
    public String getTarget() { return target; }
    public int getIntervalSeconds() { return intervalSeconds; }
    public int getTimeoutMs() { return timeoutMs; }
    public int getFailureThreshold() { return failureThreshold; }
    public boolean isActive() { return active; }
    public Instant getCreatedAt() { return createdAt; }

    public void setName(String name) { this.name = name; }
    public void setType(MonitorType type) { this.type = type; }
    public void setTarget(String target) { this.target = target; }
    public void setIntervalSeconds(int intervalSeconds) { this.intervalSeconds = intervalSeconds; }
    public void setTimeoutMs(int timeoutMs) { this.timeoutMs = timeoutMs; }
    public void setFailureThreshold(int failureThreshold) { this.failureThreshold = failureThreshold; }
    public void setActive(boolean active) { this.active = active; }
}