package com.example.demo.util;

import com.alibaba.fastjson.JSON;
import com.example.demo.config.MqttConfig;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@Component
public class MqttUtils {

    private static Logger logger = LoggerFactory.getLogger(MqttUtils.class);

    @Autowired
    private MqttConfig config;

    private MqttClient defaultClient;

    @PostConstruct
    public void init() {
        defaultClient = MqttClientManager.createMqttClient(config);
    }

    public void publish(String topic, Object message) {
        if (defaultClient.isConnected()) {
            try {
                logger.info("mqttClient publish message, topic={}, payload={}", topic, message);
                defaultClient.publish(topic, JSON.toJSONString(message).getBytes(), 1, false);
            } catch (MqttException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }
}