package com.example.springcloudgateway.component;

import lombok.*;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class L1Filter extends AbstractGatewayFilterFactory<L1Filter.Config> implements Ordered {

    public L1Filter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            // pre Filter 처리
            // pre가 라우팅 필터 등록 시 true일 경우 아래 함수가 실행됨
            if (config.isPre()) System.out.println("[pre] Local Filter 1");

            // post Filter 처리
            // post가 라우팅 필터 등록 시 ture일 경우 아래 함수가 실행됨
            return chain.filter(exchange)
                    .then(Mono.fromRunnable(() -> {
                        if (config.isPost()) System.out.println("[post] Local Filter 1");
                    }));
        };
    }

    @Override
    public int getOrder() {
        return 1;
    }

    // 변수 등록
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Config {
        private boolean pre;
        private boolean post;
    }
}
