package com.example.demo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class MqttConfig {

    @Value("${mqtt.prefix}")
    private String clientIdPrefix; // clientId前缀

    @Value("${mqtt.serverUrl}")
    private String serverUri;

    @Value("${mqtt.connectionTimeout}")
    private int connectionTimeout; // 建连接的超时时间

    @Value("${mqtt.username}")
    private String username;

    @Value("${mqtt.password}")
    private String password;

    @Value("${mqtt.topic}")
    private String topic;
}