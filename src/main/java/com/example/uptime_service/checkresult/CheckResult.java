package com.example.uptime_service.checkresult;

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
@Table(name = "check_result")
public class CheckResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "monitor_id", nullable = false)
    private Long monitorId;

    @Column(name = "checked_at", nullable = false)
    private Instant checkedAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CheckStatus status;

    @Column(name = "response_time_ms")
    private Integer responseTimeMs;

    @Column(name = "status_code")
    private Integer statusCode;

    @Column(name = "error_message")
    private String errorMessage;

    protected CheckResult() {}

    public CheckResult(Long monitorId, Instant checkedAt, CheckStatus status,
                       Integer responseTimeMs, Integer statusCode, String errorMessage) {
        this.monitorId = monitorId;
        this.checkedAt = checkedAt;
        this.status = status;
        this.responseTimeMs = responseTimeMs;
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
    }

    public Long getId() {
        return this.id;
    }

    public Long getMonitorId() {
        return this.monitorId;
    }

    public Instant getCheckedAt() {
        return this.checkedAt;
    }

    public CheckStatus getStatus() {
        return this.status;
    }

    public Integer getResponseTimeMs() {
        return this.responseTimeMs;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
 
}