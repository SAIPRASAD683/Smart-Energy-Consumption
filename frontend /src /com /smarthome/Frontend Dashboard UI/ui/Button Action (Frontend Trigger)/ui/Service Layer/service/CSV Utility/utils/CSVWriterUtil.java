package com.smarthome.utils;

import java.io.FileWriter;

public class CSVWriterUtil {

    public static void writeFile(String path, String content) {

        try {

            FileWriter writer = new FileWriter(path);
            writer.write(content);
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
