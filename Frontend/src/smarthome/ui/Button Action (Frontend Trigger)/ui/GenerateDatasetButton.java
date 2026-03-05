package com.smarthome.ui;

import com.smarthome.service.DataGeneratorService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerateDatasetButton implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        DataGeneratorService service = new DataGeneratorService();
        service.generateDataset();

        System.out.println("Dataset Generated Successfully!");
    }
}
