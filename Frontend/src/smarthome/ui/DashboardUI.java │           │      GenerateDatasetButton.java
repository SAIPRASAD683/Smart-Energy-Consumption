package com.smarthome.ui;

import javax.swing.*;
import java.awt.*;

public class DashboardUI extends JFrame {

    public DashboardUI() {

        setTitle("SmartHome Energy Monitoring");
        setSize(500,300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("SmartHome Energy Dataset Generator");

        JButton generateBtn = new JButton("Generate Energy Dataset");

        generateBtn.addActionListener(new GenerateDatasetButton());

        add(title);
        add(generateBtn);

        setVisible(true);
    }
}
