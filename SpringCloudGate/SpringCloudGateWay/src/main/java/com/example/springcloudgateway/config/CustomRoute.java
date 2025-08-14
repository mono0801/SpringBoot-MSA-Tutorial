package com.example.springcloudgateway.config;

import com.example.springcloudgateway.component.L1Filter;
import com.example.springcloudgateway.component.L2Filter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomRoute {

/*    @Bean
    // spring-cloud-starter-gateway-mvc는 RouteLocator가 존재하지 않음
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {

        return builder.routes()
                .route("ms1", p -> p.path("/ms1/**")
                        .filters(f -> f
                                .filter(new L1Filter().apply(new L1Filter.Config(true, true)))
                                .filter(new L2Filter().apply(new L2Filter.Config(true, false))))
                        .uri("http://localhost:8080")
                )
                .route("ms2", p -> p.path("/ms2/**")
                        .uri("http://localhost:8081"))
                .route("normal", p -> p.path("/normal/**")
                        // 대소문자 상관 X
                        //.uri("lb://NORMALCLIENT"))
                        .uri("lb://normalclient"))
                .build();
    }*/

/*    @Bean
    // spring-cloud-starter-gateway-mvc는 RouteLocator가 존재하지 않음
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {

        return builder.routes()
                .route("normal", p -> p.path("/normal/**")
                        .uri("http://localhost:8082"))
                .route("normal1", p -> p.path("/normal1/**")
                        .uri("http://localhost:8083"))
                .build();
    }*/
}
