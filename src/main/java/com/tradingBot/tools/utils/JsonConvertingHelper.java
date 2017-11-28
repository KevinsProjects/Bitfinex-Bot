package com.tradingBot.tools.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tradingBot.tools.apiClient.model.BaseObject;

import java.io.IOException;
import java.util.List;

public class JsonConvertingHelper {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static <T extends BaseObject> T getObject(String json, Class<T> className) throws IOException {
        return objectMapper.readValue(json, className);
    }

    public static <T extends BaseObject> List<T> getObjectList() {
        return null;
    }

    public static <T extends BaseObject> String getJsonFromObject(T object) throws IOException{
        return objectMapper.writeValueAsString(object);
    }
}
