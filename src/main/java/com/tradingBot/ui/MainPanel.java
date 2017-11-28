package com.tradingBot.ui;

import com.tradingBot.ui.panels.left.LeftPanel;
import com.tradingBot.ui.panels.right.RightPanel;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel{

    LeftPanel leftPanel;
    RightPanel rightPanel;

    public MainPanel() throws Exception{
        this.leftPanel = new LeftPanel();
        this.rightPanel = new RightPanel();
        this.setLayout(new BorderLayout());
        this.add(leftPanel, BorderLayout.WEST);
        this.add(rightPanel, BorderLayout.CENTER);
    }
}
