package com.cloudoer.gateway.routes;

import com.cloudoer.gateway.filter.AuthorizeGatewayFilter;
import com.cloudoer.gateway.filter.ElapsedGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/baidu/**").and().uri("http://www.baidu.com")
                        .filters(new AuthorizeGatewayFilter())).build();
    }

    @Bean
    public ElapsedGatewayFilterFactory elapsedGatewayFilterFactory() {
        return new ElapsedGatewayFilterFactory();
    }
}
