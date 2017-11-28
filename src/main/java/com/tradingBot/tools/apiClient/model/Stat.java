package com.tradingBot.tools.apiClient.model;

/**
 * Created by yevhenshkola on 10.11.2017.
 */
public class Stat extends BaseObject{

    private String period;
    private String volume;

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Stat{" +
                "period='" + period + '\'' +
                ", volume='" + volume + '\'' +
                '}';
    }
}
