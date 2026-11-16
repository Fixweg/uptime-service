package com.example.uptime_service.monitor;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/monitors")
public class MonitorController {

    private final MonitorService service;

    public MonitorController(MonitorService service) {
        this.service = service;
    }

    @GetMapping
    public List<MonitorResponse> list() {
        return service.findAll().stream().map(MonitorResponse::from).toList();
    }

    @GetMapping("/{id}")
    public MonitorResponse get(@PathVariable Long id) {
        return MonitorResponse.from(service.get(id));
    }

    @PostMapping
    public ResponseEntity<MonitorResponse> create(@Valid @RequestBody MonitorRequest request) {
        Monitor created = service.create(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(MonitorResponse.from(created));
    }

    @PutMapping("/{id}")
    public MonitorResponse update(@PathVariable Long id, @Valid @RequestBody MonitorRequest request) {
        return MonitorResponse.from(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
