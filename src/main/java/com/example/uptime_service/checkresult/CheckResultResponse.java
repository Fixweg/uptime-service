package com.example.uptime_service.checkresult;

import java.time.Instant;

public record CheckResultResponse(
        Long id, Instant checkedAt, CheckStatus status,
        Integer responseTimeMs, Integer statusCode, String errorMessage) {

    public static CheckResultResponse from(CheckResult r) {
        return new CheckResultResponse(r.getId(), r.getCheckedAt(), r.getStatus(),
                r.getResponseTimeMs(), r.getStatusCode(), r.getErrorMessage());
    }
}
