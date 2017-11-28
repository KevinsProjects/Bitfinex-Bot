package com.tradingBot.ui.panels.right;

import javax.swing.*;

import com.tradingBot.tools.apiClient.model.OrderBook;
import com.tradingBot.tools.apiClient.model.OrderBooks;

import java.awt.*;
import java.util.ArrayList;

public class OrderBookPanel extends JPanel{

    JButton button;
    private ArrayList<OrderBookEntry> entries;

    public OrderBookPanel(OrderBooks orderBooks){
    	for(OrderBook orderBook : orderBooks.getBids()) {
    		this.entries.add(new OrderBookEntry(orderBook.getPrice(), orderBook.getAmount(), orderBook.getTimestamp()));
    	}
    	for(OrderBook orderBook : orderBooks.getAsks()) {
    		this.entries.add(new OrderBookEntry(orderBook.getPrice(), orderBook.getAmount(), orderBook.getTimestamp()));
    	}
        this.setLayout(new GridLayout(15,6));
        setLabels();
    }
    
    private void setLabels() {
    	for(OrderBookEntry entry : entries) {
    		this.add(entry.getPrice());
    		this.add(entry.getAmount());
    		this.add(entry.getPrice());
    	}
    }
}
