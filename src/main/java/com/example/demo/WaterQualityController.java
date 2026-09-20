package com.example.demo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class WaterQualityController {

    private final SensorSimulator simulator;

    public WaterQualityController(SensorSimulator simulator) {
        this.simulator = simulator;
    }

    @GetMapping("/readings")
    public List<SensorReading> getAllReadings() {
        return simulator.getAllReadings();
    }

    @GetMapping("/readings/latest")
    public SensorReading getLatestReading() {
        return simulator.getLatestReading();
    }

    @GetMapping("/readings/alerts")
public List<SensorReading> getAlerts() {
    return simulator.getAllReadings().stream()
        .filter(r -> !r.isSafe())
        .toList();
}

@GetMapping("/thresholds")
public Map<String, Double> getThresholds() {
    Map<String, Double> thresholds = new HashMap<>();
    thresholds.put("phMin", simulator.getPhMin());
    thresholds.put("phMax", simulator.getPhMax());
    thresholds.put("turbidityMax", simulator.getTurbidityMax());
    return thresholds;
}

@PostMapping("/thresholds")
@PreAuthorize("hasRole('ADMIN')")
public Map<String, Double> updateThresholds(@RequestBody Map<String, Double> thresholds) {
    simulator.updateThresholds(
        thresholds.get("phMin"),
        thresholds.get("phMax"),
        thresholds.get("turbidityMax")
    );
    return getThresholds();
}
}
