package com.example.controller;
import com.example.util.EnvConfigUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
@RestController
public class HelloController {
    @Autowired
    private EnvConfigUtil envConfigUtil;

        // Non-reactive endpoint
        @GetMapping("/non-reactive")
        public String nonReactiveEndpoint() {
            String value = envConfigUtil.getProperty("app.name");
            return "Non-reactive response: " + value;
        }

        // Reactive endpoint
        @GetMapping("/reactive")
        public Mono<String> reactiveEndpoint() {
            String value = envConfigUtil.getProperty("app.name");
            return Mono.just("Reactive response: " + value);
        }
    }


