package com.metallic.app.controller;

import com.metallic.app.model.SystemMetric;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class StatusController {

    @GetMapping("/status")
    public List<SystemMetric> getSystemStatus() {
        return Arrays.asList(
            new SystemMetric("Frontend Cluster", "ONLINE"),
            new SystemMetric("Backend Engine Cluster", "OPERATIONAL"),
            new SystemMetric("Isolated Database Cluster", "SECURE")
        );
    }
}
