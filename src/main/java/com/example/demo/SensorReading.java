package com.example.demo;

import java.time.LocalDateTime;

public class SensorReading {
    private LocalDateTime timestamp;
    private double ph;
    private double turbidity;   // NTU
    private double temperature; // Celsius
    private double flowRate;    // L/min
    private boolean safe;

    public SensorReading(double ph, double turbidity, double temperature, double flowRate) {
        this.timestamp = LocalDateTime.now();
        this.ph = ph;
        this.turbidity = turbidity;
        this.temperature = temperature;
        this.flowRate = flowRate;
        this.safe = evaluateSafety();
    }

    private boolean evaluateSafety() {
        return ph >= 6.5 && ph <= 8.5 && turbidity < 5.0;
    }
    public void setSafe(boolean safe) {
    this.safe = safe;
}

    // Getters (needed for JSON conversion)
    public LocalDateTime getTimestamp() { return timestamp; }
    public double getPh() { return ph; }
    public double getTurbidity() { return turbidity; }
    public double getTemperature() { return temperature; }
    public double getFlowRate() { return flowRate; }
    public boolean isSafe() { return safe; }
}
