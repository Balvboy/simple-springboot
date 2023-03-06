package com.example.demo.lifecycle;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author zhouyang
 * @date 2022/6/14 10:54 AM
 */
//@Component
public class MyInitializingBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("========MyInitializingBean=======");
    }
}
