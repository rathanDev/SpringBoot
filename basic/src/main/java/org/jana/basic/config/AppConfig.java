package org.jana.basic.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    @ConfigurationProperties(prefix = "message")
    public MessageConfig messageConfig() {
        return new MessageConfig();
    }

}
