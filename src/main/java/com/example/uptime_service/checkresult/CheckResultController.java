package com.example.uptime_service.checkresult;

import java.util.List;

import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Max;

@Tag(name = "Check Results", description = "Prüfergebnisse eines Monitors")
@RestController
@RequestMapping("/api/monitors/{monitorId}/results")
public class CheckResultController {

    private final CheckResultService service;

    public CheckResultController(CheckResultService service) {
        this.service = service;
    }

    @Operation(summary = "Letzte Prüfergebnisse eines Monitors")
    @ApiResponse(responseCode = "404", description = "Monitor nicht gefunden",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @GetMapping
    public List<CheckResultResponse> latest(@PathVariable Long monitorId,
                                            @RequestParam(defaultValue = "50") @Max(500) int limit) {
        return service.latest(monitorId, limit).stream().map(CheckResultResponse::from).toList();
    }
}
