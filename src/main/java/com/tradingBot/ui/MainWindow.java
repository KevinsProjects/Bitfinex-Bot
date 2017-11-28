package com.tradingBot.ui;

import javax.swing.*;

public class MainWindow extends JFrame{

    MainPanel mainPanel;

    public MainWindow() throws Exception {
        this.mainPanel = new MainPanel();
        this.add(mainPanel);
        this.pack();
        this.setVisible(true);
    }
}
