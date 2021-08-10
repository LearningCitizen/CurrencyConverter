package com.jhippolyte.currencyconverter.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jhippolyte.currencyconverter.model.Currency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    public static String toJson (Object obj)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json =objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
        }
        return json;
    }
    public static void main(String [] args){
        List l = new ArrayList();
        l.add(new Currency("curA", "CU1", 1.0));
        l.add(new Currency("curB", "CU2", 1.0));
        logger.info(JsonUtils.toJson(l));
    }
}
