package com.tradingBot.ui.panels.right;

import com.tradingBot.tools.apiClient.ApiClient;
import com.tradingBot.ui.panels.left.BalancesPanel;
import com.tradingBot.ui.panels.left.OperationsPanel;

import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel{

    OrderBookPanel orderBook;
    ApiClient client = new ApiClient();

    public RightPanel() throws Exception{
        this.orderBook = new OrderBookPanel(client.getOrderBook("btcusd"));
        this.setLayout(new BorderLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        //gridBagConstraints.fill = GridBagConstraints.VERTICAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = gridBagConstraints.weighty = 1.0;
        this.add(orderBook, BorderLayout.CENTER);

        this.setBackground(Color.GREEN);
    }
}
