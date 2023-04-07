package com.apiP2M.apiGateway.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class RoutingConfig {

    @Bean

    public RouteLocator configureRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("cv-server-id", r -> r.path("/ratingsdata/**").uri("lb://RATING-DATA-SERVICE")) //dynamic routing to cv-service
                .route("oauth-server-id", r -> r.path("/oauth/**").uri("lb://AUTHORIZATION-SERVICE")) //dynamic routing to cv-service
                .build();
    }
}