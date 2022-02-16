package com.justynsoft.da.typesafe.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigBeanFactory;
import com.typesafe.config.ConfigFactory;

public class SimleConfigBuilder {
    private ExtractConfig extractConfig;
    private SparkConfig sparkConfig;

    public static void main(String[] args) {
        SimleConfigBuilder builder = new SimleConfigBuilder();
        builder.loadConfig();
    }

    public void loadConfig(){
        Config config = ConfigFactory.load();
//        this.extractConfig = ConfigBeanFactory.create(config, ExtractConfig.class);
        this.sparkConfig = ConfigBeanFactory.create(config, SparkConfig.class);
//        System.out.println(config.getString("sparkConfig.home"));

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(extractConfig));
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(sparkConfig));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }
}
