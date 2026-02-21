package com.smarthome.util;

import com.smarthome.model.EnergyRecord;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriterUtil {

    public static void writeToCsv(String filePath, List<EnergyRecord> records) {

        try {
            File file = new File(filePath);
            file.getParentFile().mkdirs(); // ensure directory exists

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            // Header
            writer.write("timestamp,fridge,ac,lights,microwave,total_power,total_energy_kwh");
            writer.newLine();

            for (EnergyRecord record : records) {
                writer.write(record.toCsv());
                writer.newLine();
            }

            writer.close();
            System.out.println("Data saved to " + filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
