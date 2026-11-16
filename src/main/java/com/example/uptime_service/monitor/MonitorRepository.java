package com.example.uptime_service.monitor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitorRepository extends JpaRepository<Monitor, Long> {

    List<Monitor> findByActiveTrue();
}
