/*
 * Copyright 2016-2021 the original author or authors from the  project.
 *
 * This file is part of the  project, see https://www..tech/
 * for more information.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jtorregrosa.meteoasv.config.apidoc;

import static org.springdoc.core.Constants.SPRINGDOC_SHOW_ACTUATOR;
import static org.springdoc.core.SpringDocUtils.getConfig;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Optional;

import com.jtorregrosa.meteoasv.config.MeteoasvProperties;
import com.jtorregrosa.meteoasv.config.apidoc.customizer.OpenApiCustomizer;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.GroupedOpenApi.Builder;
import org.springdoc.core.SpringDocConfigProperties;
import org.springdoc.core.converters.PageableOpenAPIConverter;
import org.springdoc.core.converters.models.Pageable;
import org.springdoc.core.customizers.ActuatorOpenApiCustomizer;
import org.springdoc.core.customizers.ActuatorOperationCustomizer;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import io.swagger.v3.oas.models.info.Info;

/**
 * OpenApi Groups configuration.
 * <p>
 * Warning! When having a lot of REST endpoints, OpenApi can become a performance issue.
 * In that case, you can use the "no-api-docs" Spring profile, so that this bean is ignored.
 */
@Configuration
public class SpringDocGroupsConfiguration {

    public static final String MANAGEMENT_GROUP_NAME = "MeteoASV - Management";
    public static final String DEFAULT_GROUP_NAME = "MeteoASV - Endpoints";

    static {
        /**
         * Add support to `@ParamObject Pageable`
         */
        getConfig().replaceParameterObjectWithClass(org.springframework.data.domain.Pageable.class, Pageable.class)
            .replaceParameterObjectWithClass(org.springframework.data.domain.PageRequest.class, Pageable.class)
            .replaceWithClass(ByteBuffer.class, String.class);
    }

    static final String MANAGEMENT_TITLE_SUFFIX = "Management API";
    static final String MANAGEMENT_DESCRIPTION = "Management endpoints documentation";

    private final Logger log = LoggerFactory.getLogger(SpringDocGroupsConfiguration.class);

    private final MeteoasvProperties.ApiDocs properties;

    /**
     * <p>Constructor for OpenApiAutoConfiguration.</p>
     *
     * @param meteoasvProperties a {@link com.jtorregrosa.meteoasv.config.MeteoasvProperties} object.
     */
    public SpringDocGroupsConfiguration(MeteoasvProperties meteoasvProperties) {
        this.properties = meteoasvProperties.getApiDocs();
    }

    /**
     * Add support to `@PageableAsQueryParam`
     */
    @Bean
    @ConditionalOnMissingBean
    @Lazy(false)
    PageableOpenAPIConverter pageableOpenAPIConverter() {
        return new PageableOpenAPIConverter();
    }

    /**
     *  OpenApi Customiser
     *
     * @return the Customizer of
     */
    @Bean
    public OpenApiCustomizer openApiCustomizer() {
        log.debug("Initializing  OpenApi customizer");
        return new OpenApiCustomizer(properties);
    }

    /**
     * OpenApi default group configuration.
     *
     * @return the GroupedOpenApi configuration
     */
    @Bean
    @ConditionalOnMissingBean(name = "openAPIDefaultGroupedOpenAPI")
    public GroupedOpenApi openAPIDefaultGroupedOpenAPI(
        List<OpenApiCustomiser> openApiCustomizers,
        List<OperationCustomizer> operationCustomizers,
        @Qualifier("apiFirstGroupedOpenAPI") Optional<GroupedOpenApi> apiFirstGroupedOpenAPI,
        SpringDocConfigProperties springDocConfigProperties
    ) {
        log.debug("Initializing OpenApi default group");
        Builder builder = GroupedOpenApi.builder()
            .group(DEFAULT_GROUP_NAME)
            .pathsToMatch(properties.getDefaultIncludePattern());
        openApiCustomizers.stream()
            .filter(customizer -> !(customizer instanceof ActuatorOperationCustomizer))
            .forEach(builder::addOpenApiCustomiser);
        operationCustomizers.stream()
            .filter(customizer -> !(customizer instanceof ActuatorOpenApiCustomizer))
            .forEach(builder::addOperationCustomizer);
        apiFirstGroupedOpenAPI.ifPresent(apiFirst -> {
            if (apiFirst.getPackagesToScan() != null) {
                apiFirst.getPackagesToScan().forEach(builder::packagesToExclude);
            }
        });
        return builder.build();
    }

    /**
     * OpenApi management group configuration for the management endpoints (actuator) OpenAPI docs.
     *
     * @return the GroupedOpenApi configuration
     */
    @Bean
    @ConditionalOnClass(name = "org.springframework.boot.actuate.autoconfigure.web.server.ManagementServerProperties")
    @ConditionalOnMissingBean(name = "openAPIManagementGroupedOpenAPI")
    @ConditionalOnProperty(SPRINGDOC_SHOW_ACTUATOR)
    public GroupedOpenApi openAPIManagementGroupedOpenAPI(
        @Value("${spring.application.name:application}") String appName,
        ActuatorOpenApiCustomizer actuatorOpenApiCustomizer,
        ActuatorOperationCustomizer actuatorCustomizer
    ) {
        log.debug("Initializing OpenApi management group");
        return GroupedOpenApi.builder()
            .group(MANAGEMENT_GROUP_NAME)
            .addOpenApiCustomiser(openApi -> openApi.info(new Info()
                .title(StringUtils.capitalize(appName) + " " + MANAGEMENT_TITLE_SUFFIX)
                .description(MANAGEMENT_DESCRIPTION)
                .version(properties.getVersion())
            ))
            .addOpenApiCustomiser(actuatorOpenApiCustomizer)
            .addOperationCustomizer(actuatorCustomizer)
            .pathsToMatch(properties.getManagementIncludePattern())
            .build();
    }
}
