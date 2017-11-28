package com.tradingBot.tools.utils;

public class Constants {

    public static String BASE_URL = "https://api.bitfinex.com/v1/";

    //PUBLIC ENDPOINTS
    public static String TICKER = BASE_URL + "pubticker/";
    public static String STATS = BASE_URL + "stats/";
    public static String ORDERBOOK = BASE_URL + "book/";

    //PRIVATE ENDPOINTS
    public static String ACCOUNT_INFOS = BASE_URL + "account_infos";

    //USERDATA
    public static String API_KEY = "";
    public static String API_SECRET = "";

    //CRYPTO
    public static String UTF = "UTF-8";
    public static String ALGORITHM_HMACSHA384 = "HmacSHA384";
    public static String ASCII = "ASCII";

}
