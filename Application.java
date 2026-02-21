package com.smarthome;

import com.smarthome.service.EnergyDataGeneratorService;
import com.smarthome.util.CsvWriterUtil;

public class Application {

    public static void main(String[] args) {

        System.out.println("Generating SmartHome Energy Dataset...");

        EnergyDataGeneratorService service = new EnergyDataGeneratorService();
        var records = service.generateData();

        String path = "energy-consumption-project/data/raw/energy_data.csv";
        CsvWriterUtil.writeToCsv(path, records);

        System.out.println("Generation completed successfully.");
    }
}
