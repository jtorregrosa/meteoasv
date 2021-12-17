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

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.cors.CorsConfiguration;

/**
 * Properties specific to MeteoASV.
 *
 * <p> Properties are configured in the application.yml file. </p>
 * <p> This class also load properties in the Spring Environment from the git.properties and META-INF/build-info.properties
 * files if they are found in the classpath.</p>
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
@PropertySource(value = "classpath:git.properties", ignoreResourceNotFound = true)
@PropertySource(value = "classpath:META-INF/build-info.properties", ignoreResourceNotFound = true)
public class MeteoasvProperties {

    private final Async async = new Async();

    private final Http http = new Http();

    private final Cache cache = new Cache();

    private final ApiDocs apiDocs = new ApiDocs();

    private final Metrics metrics = new Metrics();

    private final Logging logging = new Logging();

    private final CorsConfiguration cors = new CorsConfiguration();

    private final AuditEvents auditEvents = new AuditEvents();

    private final ClientApp clientApp = new ClientApp();

    private final Aemet aemet = new Aemet();

    /**
     * <p>Getter for the field <code>aemet</code>.</p>
     *
     * @return a {@link com.jtorregrosa.meteoasv.config.MeteoasvProperties.Async} object.
     */
    public Aemet getAemet() {
        return aemet;
    }


    /**
     * <p>Getter for the field <code>async</code>.</p>
     *
     * @return a {@link com.jtorregrosa.meteoasv.config.MeteoasvProperties.Async} object.
     */
    public Async getAsync() {
        return async;
    }

    /**
     * <p>Getter for the field <code>http</code>.</p>
     *
     * @return a {@link com.jtorregrosa.meteoasv.config.MeteoasvProperties.Http} object.
     */
    public Http getHttp() {
        return http;
    }

    /**
     * <p>Getter for the field <code>cache</code>.</p>
     *
     * @return a {@link com.jtorregrosa.meteoasv.config.MeteoasvProperties.Cache} object.
     */
    public Cache getCache() {
        return cache;
    }

    /**
     * <p>Getter for the field <code>api-docs</code>.</p>
     *
     * @return a {@link com.jtorregrosa.meteoasv.config.MeteoasvProperties.ApiDocs} object.
     */
    public ApiDocs getApiDocs() {
        return apiDocs;
    }

    /**
     * <p>Getter for the field <code>metrics</code>.</p>
     *
     * @return a {@link com.jtorregrosa.meteoasv.config.MeteoasvProperties.Metrics} object.
     */
    public Metrics getMetrics() {
        return metrics;
    }

    /**
     * <p>Getter for the field <code>logging</code>.</p>
     *
     * @return a {@link com.jtorregrosa.meteoasv.config.MeteoasvProperties.Logging} object.
     */
    public Logging getLogging() {
        return logging;
    }

    /**
     * <p>Getter for the field <code>cors</code>.</p>
     *
     * @return a {@link org.springframework.web.cors.CorsConfiguration} object.
     */
    public CorsConfiguration getCors() {
        return cors;
    }

    /**
     * <p>Getter for the field <code>auditEvents</code>.</p>
     *
     * @return a {@link com.jtorregrosa.meteoasv.config.MeteoasvProperties.AuditEvents} object.
     */
    public AuditEvents getAuditEvents() {
        return auditEvents;
    }

    public ClientApp getClientApp() {
        return clientApp;
    }

    public static class ClientApp {

        private String name = MeteoasvDefaults.ClientApp.NAME;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Aemet {
        private String apiKey;

        public String getApiKey() {
            return apiKey;
        }

        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }
    }

    public static class Async {

        private int corePoolSize = MeteoasvDefaults.Async.CORE_POOL_SIZE;

        private int maxPoolSize = MeteoasvDefaults.Async.MAX_POOL_SIZE;

        private int queueCapacity = MeteoasvDefaults.Async.QUEUE_CAPACITY;

        public int getCorePoolSize() {
            return corePoolSize;
        }

        public void setCorePoolSize(int corePoolSize) {
            this.corePoolSize = corePoolSize;
        }

        public int getMaxPoolSize() {
            return maxPoolSize;
        }

        public void setMaxPoolSize(int maxPoolSize) {
            this.maxPoolSize = maxPoolSize;
        }

        public int getQueueCapacity() {
            return queueCapacity;
        }

        public void setQueueCapacity(int queueCapacity) {
            this.queueCapacity = queueCapacity;
        }
    }

    public static class Http {

        private final Cache cache = new Cache();

        public Cache getCache() {
            return cache;
        }

        public static class Cache {

            private int timeToLiveInDays = MeteoasvDefaults.Http.Cache.TIME_TO_LIVE_IN_DAYS;

            public int getTimeToLiveInDays() {
                return timeToLiveInDays;
            }

            public void setTimeToLiveInDays(int timeToLiveInDays) {
                this.timeToLiveInDays = timeToLiveInDays;
            }
        }
    }

    public static class Cache {

        private final Ehcache ehcache = new Ehcache();

        public Ehcache getEhcache() {
            return ehcache;
        }

        public static class Ehcache {

            private int timeToLiveSeconds = MeteoasvDefaults.Cache.Ehcache.TIME_TO_LIVE_SECONDS;

            private long maxEntries = MeteoasvDefaults.Cache.Ehcache.MAX_ENTRIES;

            public int getTimeToLiveSeconds() {
                return timeToLiveSeconds;
            }

            public void setTimeToLiveSeconds(int timeToLiveSeconds) {
                this.timeToLiveSeconds = timeToLiveSeconds;
            }

            public long getMaxEntries() {
                return maxEntries;
            }

            public void setMaxEntries(long maxEntries) {
                this.maxEntries = maxEntries;
            }
        }
    }

    public static class ApiDocs {

        private String title = MeteoasvDefaults.ApiDocs.TITLE;

        private String description = MeteoasvDefaults.ApiDocs.DESCRIPTION;

        private String version = MeteoasvDefaults.ApiDocs.VERSION;

        private String termsOfServiceUrl = MeteoasvDefaults.ApiDocs.TERMS_OF_SERVICE_URL;

        private String contactName = MeteoasvDefaults.ApiDocs.CONTACT_NAME;

        private String contactUrl = MeteoasvDefaults.ApiDocs.CONTACT_URL;

        private String contactEmail = MeteoasvDefaults.ApiDocs.CONTACT_EMAIL;

        private String license = MeteoasvDefaults.ApiDocs.LICENSE;

        private String licenseUrl = MeteoasvDefaults.ApiDocs.LICENSE_URL;

        private String defaultIncludePattern = MeteoasvDefaults.ApiDocs.DEFAULT_INCLUDE_PATTERN;

        private String managementIncludePattern = MeteoasvDefaults.ApiDocs.MANAGEMENT_INCLUDE_PATTERN;

        private Server[] servers = {};

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getTermsOfServiceUrl() {
            return termsOfServiceUrl;
        }

        public void setTermsOfServiceUrl(String termsOfServiceUrl) {
            this.termsOfServiceUrl = termsOfServiceUrl;
        }

        public String getContactName() {
            return contactName;
        }

        public void setContactName(String contactName) {
            this.contactName = contactName;
        }

        public String getContactUrl() {
            return contactUrl;
        }

        public void setContactUrl(String contactUrl) {
            this.contactUrl = contactUrl;
        }

        public String getContactEmail() {
            return contactEmail;
        }

        public void setContactEmail(String contactEmail) {
            this.contactEmail = contactEmail;
        }

        public String getLicense() {
            return license;
        }

        public void setLicense(String license) {
            this.license = license;
        }

        public String getLicenseUrl() {
            return licenseUrl;
        }

        public void setLicenseUrl(String licenseUrl) {
            this.licenseUrl = licenseUrl;
        }

        public String getDefaultIncludePattern() {
            return defaultIncludePattern;
        }

        public void setDefaultIncludePattern(String defaultIncludePattern) {
            this.defaultIncludePattern = defaultIncludePattern;
        }

        public String getManagementIncludePattern() {
            return managementIncludePattern;
        }

        public void setManagementIncludePattern(String managementIncludePattern) {
            this.managementIncludePattern = managementIncludePattern;
        }

        public Server[] getServers() {
            return servers;
        }

        public void setServers(final Server[] servers) {
            this.servers = servers;
        }

        public static class Server {
            private String url;
            private String description;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }
        }
    }

    public static class Metrics {

        private final Logs logs = new Logs();

        public Logs getLogs() {
            return logs;
        }

        public static class Logs {

            private boolean enabled = MeteoasvDefaults.Metrics.Logs.ENABLED;

            private long reportFrequency = MeteoasvDefaults.Metrics.Logs.REPORT_FREQUENCY;

            public boolean isEnabled() {
                return enabled;
            }

            public void setEnabled(boolean enabled) {
                this.enabled = enabled;
            }

            public long getReportFrequency() {
                return reportFrequency;
            }

            public void setReportFrequency(long reportFrequency) {
                this.reportFrequency = reportFrequency;
            }
        }
    }

    public static class Logging {

        private final Logstash logstash = new Logstash();
        private boolean useJsonFormat = MeteoasvDefaults.Logging.USE_JSON_FORMAT;

        public boolean isUseJsonFormat() {
            return useJsonFormat;
        }

        public void setUseJsonFormat(boolean useJsonFormat) {
            this.useJsonFormat = useJsonFormat;
        }

        public Logstash getLogstash() {
            return logstash;
        }

        public static class Logstash {

            private boolean enabled = MeteoasvDefaults.Logging.Logstash.ENABLED;

            private String host = MeteoasvDefaults.Logging.Logstash.HOST;

            private int port = MeteoasvDefaults.Logging.Logstash.PORT;

            private int ringBufferSize = MeteoasvDefaults.Logging.Logstash.RING_BUFFER_SIZE;

            public boolean isEnabled() {
                return enabled;
            }

            public void setEnabled(boolean enabled) {
                this.enabled = enabled;
            }

            public String getHost() {
                return host;
            }

            public void setHost(String host) {
                this.host = host;
            }

            public int getPort() {
                return port;
            }

            public void setPort(int port) {
                this.port = port;
            }

            public int getRingBufferSize() {
                return ringBufferSize;
            }

            public void setRingBufferSize(int ringBufferSize) {
                this.ringBufferSize = ringBufferSize;
            }
        }
    }

    public static class AuditEvents {
        private int retentionPeriod = MeteoasvDefaults.AuditEvents.RETENTION_PERIOD;

        public int getRetentionPeriod() {
            return retentionPeriod;
        }

        public void setRetentionPeriod(int retentionPeriod) {
            this.retentionPeriod = retentionPeriod;
        }
    }
}
