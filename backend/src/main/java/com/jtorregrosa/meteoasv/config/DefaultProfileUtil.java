/*
 * Copyright (c) 2021 Jorge Torregrosa
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.jtorregrosa.meteoasv.config;

import org.springframework.boot.SpringApplication;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class to load a Spring profile to be used as default
 * when there is no {@code spring.profiles.active} set in the environment or as command line argument.
 * If the value is not available in {@code application.yml} then {@code dev} profile will be used as default.
 */
public final class DefaultProfileUtil {

    private static final String SPRING_PROFILE_DEFAULT = "spring.profiles.default";

    private DefaultProfileUtil() {
    }

    /**
     * Set a default to use when no profile is configured.
     *
     * @param app the Spring application.
     */
    public static void addDefaultProfile(SpringApplication app) {
        Map<String, Object> defProperties = new HashMap<>();
        /*
         * The default profile to use when no other profiles are defined
         * This cannot be set in the application.yml file.
         * See https://github.com/spring-projects/spring-boot/issues/1219
         */
        defProperties.put(SPRING_PROFILE_DEFAULT, MeteoasvConstants.SPRING_PROFILE_DEVELOPMENT);
        app.setDefaultProperties(defProperties);
    }
}
