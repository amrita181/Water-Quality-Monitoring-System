package com.example.demo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class SensorSimulator {

    private final List<SensorReading> readings = new CopyOnWriteArrayList<>();
    private final Random random = new Random();
    private double phMin = 6.5;
private double phMax = 8.5;
private double turbidityMax = 5.0;

public double getPhMin() { return phMin; }
public double getPhMax() { return phMax; }
public double getTurbidityMax() { return turbidityMax; }

public void updateThresholds(double phMin, double phMax, double turbidityMax) {
    this.phMin = phMin;
    this.phMax = phMax;
    this.turbidityMax = turbidityMax;
}

    @Scheduled(fixedRate = 3000)
    public void generateReading() {
        double ph = 6.0 + random.nextDouble() * 3;
        double turbidity = random.nextDouble() * 8;
        double temperature = 20 + random.nextDouble() * 10;
        double flowRate = 1 + random.nextDouble() * 5;

        SensorReading reading = new SensorReading(ph, turbidity, temperature, flowRate);
boolean safe = ph >= phMin && ph <= phMax && turbidity < turbidityMax;
reading.setSafe(safe);
readings.add(reading);

        if (readings.size() > 50) {
            readings.remove(0);
        }
    }

    public List<SensorReading> getAllReadings() {
        return readings;
    }

    public SensorReading getLatestReading() {
        if (readings.isEmpty()) return null;
        return readings.get(readings.size() - 1);
    }
}
