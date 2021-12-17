package com.jtorregrosa.meteoasv.config.apidoc;

import org.springdoc.core.SpringDocConfigProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnAvailableEndpoint;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>OpenApiEndpointConfiguration class.</p>
 */
@Configuration
@ConditionalOnClass(SpringDocConfigProperties.class)
@AutoConfigureAfter(SpringDocAutoConfiguration.class)
public class OpenApiEndpointConfiguration {

    /**
     * <p>OpenApiEndpoint.</p>
     *
     * @param springDocConfigProperties a {@link org.springdoc.core.SpringDocConfigProperties} object.
     * @return a {@link OpenApiEndpoint} object.
     */
    @Bean
    @ConditionalOnBean({SpringDocConfigProperties.class})
    @ConditionalOnMissingBean
    @ConditionalOnAvailableEndpoint
    public OpenApiEndpoint OpenApiEndpoint(SpringDocConfigProperties springDocConfigProperties, @Value("${spring.application.name:application}") String appName) {
        return new OpenApiEndpoint(springDocConfigProperties, appName);
    }
}
