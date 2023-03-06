package com.example.demo.listener;

import org.springframework.context.LifecycleProcessor;
import org.springframework.stereotype.Component;

@Component(value = "lifecycleProcessor")
public class CustomLifeCycle implements LifecycleProcessor {

    @Override
    public void onRefresh() {

    }

    @Override
    public void onClose() {
        System.out.println("life cycle on close");
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {
        System.out.println("life cycle stop");
    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
