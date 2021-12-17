package com.jtorregrosa.meteoasv.config.apidoc;

import com.jtorregrosa.meteoasv.config.MeteoasvProperties;
import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.SpringDocConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import static com.jtorregrosa.meteoasv.config.MeteoasvConstants.SPRING_PROFILE_API_DOCS;

/**
 * OpenAPI configuration.
 * <p>
 * Warning! When having a lot of REST endpoints, OpenApi can become a performance issue.
 * In that case, you can use the "no-api-docs" Spring profile, so that this bean is ignored.
 */
@Configuration
@ConditionalOnWebApplication
@ConditionalOnClass(OpenAPI.class)
@Profile(SPRING_PROFILE_API_DOCS)
@AutoConfigureBefore(SpringDocConfiguration.class)
@AutoConfigureAfter(MeteoasvProperties.class)
@Import(SpringDocGroupsConfiguration.class)
public class SpringDocAutoConfiguration {
}
