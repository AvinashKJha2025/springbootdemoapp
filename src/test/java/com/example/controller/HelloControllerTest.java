package com.example.controller;

import com.example.util.EnvConfigUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.mockito.Mockito.when;

@WebFluxTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private EnvConfigUtil envConfigUtil;

    @Test
    void testNonReactiveEndpoint() {
        when(envConfigUtil.getProperty("app.name")).thenReturn("Test Application");

        webTestClient.get().uri("/non-reactive")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualTo("Non-reactive response: Test Application");
    }

    @Test
    void testReactiveEndpoint() {
        when(envConfigUtil.getProperty("app.name")).thenReturn("Test Application");

        webTestClient.get().uri("/reactive")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualTo("Reactive response: Test Application");
    }
}
