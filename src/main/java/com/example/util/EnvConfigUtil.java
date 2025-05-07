package com.example.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
// TODO: review use of 'EnvConfigUtil'
// TODO: review use of 'EnvConfigUtil'
// TODO: review use of 'EnvConfigUtil'
public class EnvConfigUtil {
    @Value("${app.name}")
    private  String appName;

    public  String getProperty(String key) {
        // In real cases, fetch properties from application properties or yml files
        if ("app.name".equals(key)) {
            return appName;
        }
        return null;
    }
}
