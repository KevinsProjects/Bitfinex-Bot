package com.tradingBot.tools.apiClient.model;

import java.util.List;

public class OrderBooks {
	
	private List<OrderBook> bids;
	private List<OrderBook> asks;
	
	public List<OrderBook> getBids() {
		return bids;
	}
	public void setBids(List<OrderBook> bids) {
		this.bids = bids;
	}
	public List<OrderBook> getAsks() {
		return asks;
	}
	public void setAsks(List<OrderBook> asks) {
		this.asks = asks;
	}
}
