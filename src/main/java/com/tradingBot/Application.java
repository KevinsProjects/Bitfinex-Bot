package com.tradingBot;

import com.tradingBot.tools.apiClient.ApiClient;
import com.tradingBot.ui.MainWindow;

public class Application {

    public ApiClient apiClient;

    public Application() {
        apiClient = new ApiClient();
    }

    public static void main(String[] argv) throws Exception{
        System.out.println("[*] BITFINEX trading bot");
        System.out.println("[x] start");
        System.out.println("[x] getting Ticker");
        Application application = new Application();
//        application.apiClient.getStats("btcusd");
//        application.apiClient.getTicker("btcusd");
//        application.apiClient.getTicker("btcusd");
//        application.apiClient.getTicker("btcusd");
//        application.apiClient.getTicker("btcusd");
//        application.apiClient.getTicker("btcusd");
//        System.out.println();
        //application.apiClient.getAccountInfos();
        //application.apiClient.getOrderBook("btcusd");
        MainWindow mainWindow = new MainWindow();
        System.out.println("[x] end");
    }
}
