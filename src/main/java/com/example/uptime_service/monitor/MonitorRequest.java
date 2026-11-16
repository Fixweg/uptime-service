package com.example.uptime_service.monitor;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Input object for POST and PUT. 
 * For safty reasons this entity will not be addressed directly by API
 * so that clients cant set internal fields such as id an createdAt.
 */
public record MonitorRequest(
        @NotBlank @Size(max = 100) String name,
        @NotNull MonitorType type,
        @NotBlank @Size(max = 255) String target,
        @NotNull @Min(10) Integer intervalSeconds,
        @NotNull @Min(100) @Max(60000) Integer timeoutMs,
        @NotNull @Min(1) @Max(10) Integer failureThreshold,
        Boolean enabled
) {
}
