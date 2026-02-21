package com.smarthome.service;

import com.smarthome.model.EnergyRecord;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnergyDataGeneratorService {

    private static final Random random = new Random(42); // reproducible seed

    public List<EnergyRecord> generateData() {

        List<EnergyRecord> records = new ArrayList<>();

        LocalDateTime start = LocalDateTime.of(2023, 1, 1, 0, 0);
        LocalDateTime end = LocalDateTime.of(2023, 6, 30, 23, 0);

        LocalDateTime current = start;

        int fridgeCycleCounter = 0;

        while (!current.isAfter(end)) {

            int month = current.getMonthValue();
            int hour = current.getHour();

            // Fridge cyclic pattern (3 ON, 1 OFF)
            int fridge = 0;
            if (fridgeCycleCounter < 3) {
                fridge = random.nextInt(100, 200);
            }
            fridgeCycleCounter = (fridgeCycleCounter + 1) % 4;

            // AC seasonal probability
            int ac = 0;
            double acProb = (month >= 4) ? 0.8 : 0.1;
            if (random.nextDouble() < acProb) {
                ac = random.nextInt(1000, 2500);
            }

            // Lights night probability (18:00 - 05:59)
            int lights = 0;
            boolean isNight = (hour >= 18 || hour < 6);
            double lightProb = isNight ? 0.9 : 0.1;
            if (random.nextDouble() < lightProb) {
                lights = random.nextInt(20, 100);
            }

            // Microwave short bursts
            int microwave = 0;
            if (random.nextDouble() < 0.1) {
                microwave = random.nextInt(800, 1200);
            }

            records.add(new EnergyRecord(
                    current, fridge, ac, lights, microwave
            ));

            current = current.plusHours(1);
        }

        return records;
    }
}
