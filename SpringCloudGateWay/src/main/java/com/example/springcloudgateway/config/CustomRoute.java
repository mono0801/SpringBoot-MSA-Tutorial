package com.example.springcloudgateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomRoute {

    @Bean
    // spring-cloud-starter-gateway-mvc는 RouteLocator가 존재하지 않음
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {

        return builder.routes()
                .route("ms1", p -> p.path("/ms1/**")
                        .uri("http://localhost:8080"))
                .route("ms2", p -> p.path("/ms2/**")
                        .uri("http://localhost:8081"))
                .route("normal", p -> p.path("/normal/**")
                        .uri("lb://NORMALCLIENT"))
                .build();
    }
}
