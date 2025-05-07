package com.example.controller;
// TODO: review use of 'EnvConfigUtil'
import com.example.util.EnvConfigUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloController {
    @Autowired
// TODO: review use of 'EnvConfigUtil'
    private EnvConfigUtil envConfigUtil;

        // Non-reactive endpoint
        @GetMapping("/non-reactive")
        public String nonReactiveEndpoint() {
            String value = envConfigUtil.getProperty("app.name");
            return "Non-reactive response: " + value;
        }

        // Reactive endpoint
        @GetMapping("/reactive")
        // TODO: review conversion from reactive to non-reactive
        public String reactiveEndpoint() {
        // TODO: review conversion from reactive to non-reactive
        String value = envConfigUtil.getProperty("app.name");
        return "Reactive response: " + value;
        }
    }
