package com.tradingBot.ui.panels.left;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class BalancesPanel extends JPanel{

    JLabel balancesLabel;
    JLabel btcLabel;
    JLabel btcValue;
    JLabel ltcLabel;
    JLabel ltcValue;

    public BalancesPanel(){
        setLayout(new GridLayout(2, 2, 0, 0));
        setTitle();
        
        this.balancesLabel = new JLabel("BTC");
        balancesLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        this.add(balancesLabel);
        
        this.btcValue = new JLabel("0.00");
        btcValue.setFont(new Font("Dialog", Font.BOLD, 16));
        this.add(btcValue);
        
        this.ltcLabel = new JLabel("LTC");
        ltcLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        this.add(ltcLabel);
        
        this.ltcValue = new JLabel("0.00");
        ltcValue.setFont(new Font("Dialog", Font.BOLD, 16));
        this.add(ltcValue);
    }
    
    private void setTitle() {
    	String title = "Balances";
    	Border border = BorderFactory.createTitledBorder(title);
    	this.setBorder(border);
    }
}
