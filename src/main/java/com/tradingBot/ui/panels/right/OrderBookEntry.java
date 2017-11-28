package com.tradingBot.ui.panels.right;

import java.util.List;

import javax.swing.JLabel;

public class OrderBookEntry {

	private JLabel price;
	private JLabel amount;
	private JLabel timestamp;
	
	public OrderBookEntry(String price, String amount, String timestamp) {
		this.price = new JLabel(price);
		this.amount = new JLabel(amount);
		this.timestamp = new JLabel(timestamp);
	}
	
	public JLabel getPrice() {
		return price;
	}

	public void setPrice(JLabel price) {
		this.price = price;
	}

	public JLabel getAmount() {
		return amount;
	}

	public void setAmount(JLabel amount) {
		this.amount = amount;
	}

	public JLabel getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(JLabel timestamp) {
		this.timestamp = timestamp;
	}

}
