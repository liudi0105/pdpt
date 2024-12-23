package com.pt.server.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@ConfigurationProperties("app")
@Getter
@Setter
public class AppProperties {
    private Set<String> acceptedUrls;
}
