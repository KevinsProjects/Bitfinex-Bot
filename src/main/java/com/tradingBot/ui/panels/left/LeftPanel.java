package com.tradingBot.ui.panels.left;

import javax.swing.*;
import java.awt.*;

public class LeftPanel extends JPanel{

    BalancesPanel balancesPanel;
    OperationsPanel operationsPanel;

    public LeftPanel(){
        this. balancesPanel = new BalancesPanel();
        this.operationsPanel = new OperationsPanel();
        this.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        //gridBagConstraints.weighty = 0.3;
        gridBagConstraints.ipady = 100;
        this.add(operationsPanel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 0;
        //gridBagConstraints.weighty = 0.7;
        this.add(balancesPanel, gridBagConstraints);

        this.setBackground(Color.BLUE);
    }
}
