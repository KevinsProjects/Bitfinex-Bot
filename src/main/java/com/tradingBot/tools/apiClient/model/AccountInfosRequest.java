package com.tradingBot.tools.apiClient.model;

public class AccountInfosRequest extends BaseObject{

    private String request;
    private String nonce;

    public AccountInfosRequest(String request) {
        this.request = request;
        this.nonce = Long.toString(System.currentTimeMillis());
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }
}
