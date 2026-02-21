package com.smarthome.model;

import java.time.LocalDateTime;

public class EnergyRecord {

    private LocalDateTime timestamp;
    private int fridge;
    private int ac;
    private int lights;
    private int microwave;
    private int totalPower;
    private double totalEnergyKwh;

    public EnergyRecord(LocalDateTime timestamp,
                        int fridge,
                        int ac,
                        int lights,
                        int microwave) {
        this.timestamp = timestamp;
        this.fridge = fridge;
        this.ac = ac;
        this.lights = lights;
        this.microwave = microwave;
        this.totalPower = fridge + ac + lights + microwave;
        this.totalEnergyKwh = totalPower / 1000.0;
    }

    public String toCsv() {
        return String.format("%s,%d,%d,%d,%d,%d,%.3f",
                timestamp, fridge, ac, lights, microwave,
                totalPower, totalEnergyKwh);
    }
}
