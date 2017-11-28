package com.tradingBot.tools.apiClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import com.tradingBot.tools.apiClient.model.AccountInfosRequest;
import com.tradingBot.tools.apiClient.model.BaseObject;
import com.tradingBot.tools.apiClient.model.OrderBooks;
import com.tradingBot.tools.apiClient.model.Stat;
import com.tradingBot.tools.apiClient.model.Ticker;
import com.tradingBot.tools.utils.Constants;
import com.tradingBot.tools.utils.JsonConvertingHelper;
import com.tradingBot.ui.panels.right.OrderBookPanel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Base64;

import static com.tradingBot.tools.utils.CryptoHelper.hmacDigest;

public class ApiClient {

    private CloseableHttpClient httpClient;
    private ObjectMapper objectMapper;

    public ApiClient() {

        objectMapper = new ObjectMapper();
    }

    public void getAccountInfos() throws IOException{
        String jsonInfos = sendPrivateEndpointRequestForJson(Constants.ACCOUNT_INFOS, new AccountInfosRequest("/v1/account_infos"));
        System.out.println(jsonInfos);
    }

    public void getTicker(String currency) throws Exception {
        String jsonTicker = sendPublicEndpointRequestForJson(currency, Constants.TICKER);
        Ticker ticker = objectMapper.readValue(jsonTicker, Ticker.class);
        System.out.println(ticker.toString());
    }

    public void getStats(String currency) throws Exception {
        httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(Constants.STATS + currency);
        CloseableHttpResponse response = httpClient.execute(request);
        BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String jsonString = br.readLine();
        List<Stat> list = objectMapper.readValue(jsonString,
                TypeFactory.defaultInstance().constructCollectionType(List.class,
                        Stat.class));
        response.close();
        System.out.println(list.get(0).toString());
    }
    
    public OrderBooks getOrderBook(String currency) throws Exception{
    	httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(Constants.ORDERBOOK + currency);
        request.setHeader("limit_bids", "15");
        request.setHeader("limit_aksk", "15");
        CloseableHttpResponse response = httpClient.execute(request);
        BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String jsonString = br.readLine();
        OrderBooks orderBook = objectMapper.readValue(jsonString, OrderBooks.class);
        response.close();
        System.out.println(orderBook.getAsks().get(0).getPrice());
        return orderBook;
    }

    private String sendPublicEndpointRequestForJson(String currency, String url) throws Exception{
        httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse response = sendGetRequest(url + currency);
        return getJsonStringFromHttpResponse(response);
    }

    private <T extends BaseObject> String sendPrivateEndpointRequestForJson(String url, T requestObject) throws IOException{
        httpClient = HttpClientBuilder.create().build();
        String payload = JsonConvertingHelper.getJsonFromObject(requestObject);
        CloseableHttpResponse response = sendPostRequest(url, payload);
        return getJsonStringFromHttpResponse(response);
    }

    private CloseableHttpResponse sendGetRequest(String url) throws Exception{
        HttpGet request = new HttpGet(url);
        return httpClient.execute(request);
    }

    private CloseableHttpResponse sendPostRequest(String url, String payload) throws IOException{
        String payload_base64 = Base64.getEncoder().encodeToString(payload.getBytes());
        String payload_sha384hmac = hmacDigest(payload_base64, Constants.API_SECRET, Constants.ALGORITHM_HMACSHA384);
        HttpPost request = new HttpPost(url);
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Accept", "application/json");
        request.setHeader("X-BFX-APIKEY", Constants.API_KEY);
        request.setHeader("X-BFX-PAYLOAD", payload_base64);
        request.setHeader("X-BFX-SIGNATURE", payload_sha384hmac);
        return httpClient.execute(request);
    }

    private String getJsonStringFromHttpResponse(CloseableHttpResponse response) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String jsonString = br.readLine();
        br.close();
        response.close();
        return jsonString;
    }
}
