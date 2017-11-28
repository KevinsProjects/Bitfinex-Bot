package com.tradingBot.tools.apiClient.model;

public class Ticker extends BaseObject{

    private String mid;
    private String bid;
    private String ask;
    private String last_price;
    private String low;
    private String high;
    private String volume;
    private String timestamp;

    public Ticker() {
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getLast_price() {
        return last_price;
    }

    public void setLast_price(String last_price) {
        this.last_price = last_price;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Ticker{" +
                "mid='" + mid + '\'' +
                ", bid='" + bid + '\'' +
                ", ask='" + ask + '\'' +
                ", last_price='" + last_price + '\'' +
                ", low='" + low + '\'' +
                ", high='" + high + '\'' +
                ", volume='" + volume + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }

}
