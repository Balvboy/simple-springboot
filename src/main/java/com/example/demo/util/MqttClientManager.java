package com.example.demo.util;

import cn.hutool.core.lang.UUID;
import com.example.demo.config.MqttConfig;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 负责管理mqtt client,并提供接口
 */
public class MqttClientManager {

    private static Logger logger = LoggerFactory.getLogger(MqttClientManager.class);

    /**
     * max inflight window
     * 默认为10，并发量大时会报Too many publishes in progress (32202)
     * 此处设置为500
     * 2019/03/14 wdl
     */
    private static final int MAX_INFLIGHT = 500;

    /**
     * 初始化mqtt client
     */
    public static MqttClient createMqttClient(MqttConfig mqttConfig) {
        MqttClient mqttClient = null;
        try {
            String clientId = UUID.fastUUID().toString();
            mqttClient = new MqttClient(mqttConfig.getServerUri(), clientId, new MemoryPersistence());
            MqttConnectOptions connectOptions = new MqttConnectOptions();
            connectOptions.setCleanSession(true);
            connectOptions.setAutomaticReconnect(true);
            connectOptions.setConnectionTimeout(mqttConfig.getConnectionTimeout());
            connectOptions.setUserName(mqttConfig.getUsername());
            connectOptions.setPassword(mqttConfig.getPassword().toCharArray());
            connectOptions.setMaxInflight(MAX_INFLIGHT);
            mqttClient.connect(connectOptions);
            if (!mqttClient.isConnected()) {
                logger.error("mqq client连接失败, config: {}", mqttConfig.toString());
            } else {
                logger.info("mqtt client连接成功, config: {}", mqttConfig.toString());
            }
        } catch (MqttException e) {
            e.printStackTrace();
        }

        return mqttClient;
    }
}
