package com.smarthome.service;

import com.smarthome.utils.CSVWriterUtil;

import java.time.LocalDateTime;
import java.util.Random;

public class DataGeneratorService {

    public void generateDataset() {

        LocalDateTime start = LocalDateTime.of(2023,1,1,0,0);
        LocalDateTime end = LocalDateTime.of(2023,6,30,23,0);

        Random rand = new Random();

        StringBuilder data = new StringBuilder();

        data.append("timestamp,fridge,ac,lights,microwave,total_power\n");

        LocalDateTime current = start;

        while(!current.isAfter(end)) {

            int month = current.getMonthValue();
            int hour = current.getHour();

            int fridge = rand.nextDouble()<0.7 ? rand.nextInt(151)+50 : 0;

            double acProb = month>=4 ? 0.8 : 0.1;
            int ac = rand.nextDouble()<acProb ? rand.nextInt(1501)+1000 : 0;

            double lightProb = (hour>=18 || hour<=6) ? 0.9 : 0.1;
            int lights = rand.nextDouble()<lightProb ? rand.nextInt(81)+20 : 0;

            int microwave = rand.nextDouble()<0.1 ? rand.nextInt(401)+800 : 0;

            int total = fridge + ac + lights + microwave;

            data.append(current+","+fridge+","+ac+","+lights+","+microwave+","+total+"\n");

            current = current.plusHours(1);
        }

        CSVWriterUtil.writeFile("data/energy_data.csv", data.toString());

    }
}
