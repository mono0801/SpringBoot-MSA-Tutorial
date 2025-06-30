package com.example.springcloudgateway.component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class L2Filter extends AbstractGatewayFilterFactory<L2Filter.Config> implements Ordered {

    public L2Filter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            if (config.isPre()) System.out.println("[pre] Local Filter 2");

            return chain.filter(exchange)
                    .then(Mono.fromRunnable(() -> {
                        if (config.isPost()) System.out.println("[post] Local Filter 2");
                    }));
        };
    }

    @Override
    public int getOrder() {
        return 2;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Config {
        private boolean pre;
        private boolean post;
    }
}
