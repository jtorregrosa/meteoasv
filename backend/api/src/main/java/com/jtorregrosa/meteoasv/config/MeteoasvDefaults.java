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

public final class MeteoasvDefaults {
    private static final String DEFAULTS_CONSTANT_CLASS_EXCEPTION_MESSAGE = "Defaults constant class";

    private MeteoasvDefaults() {
        throw new IllegalStateException(DEFAULTS_CONSTANT_CLASS_EXCEPTION_MESSAGE);
    }

    public static final class ClientApp {

        public static final String NAME = "meteoasvapp";

        private ClientApp() {
            throw new IllegalStateException(DEFAULTS_CONSTANT_CLASS_EXCEPTION_MESSAGE);
        }
    }

    public static final class Async {

        public static final int CORE_POOL_SIZE = 2;
        public static final int MAX_POOL_SIZE = 50;
        public static final int QUEUE_CAPACITY = 10000;

        private Async() {
            throw new IllegalStateException(DEFAULTS_CONSTANT_CLASS_EXCEPTION_MESSAGE);
        }
    }

    public static final class Http {
        private Http() {
            throw new IllegalStateException(DEFAULTS_CONSTANT_CLASS_EXCEPTION_MESSAGE);
        }

        public static final class Cache {

            public static final int TIME_TO_LIVE_IN_DAYS = 1461; // 4 years (including leap day)

            private Cache() {
                throw new IllegalStateException(DEFAULTS_CONSTANT_CLASS_EXCEPTION_MESSAGE);
            }
        }
    }

    public static final class Cache {
        private Cache() {
            throw new IllegalStateException(DEFAULTS_CONSTANT_CLASS_EXCEPTION_MESSAGE);
        }

        public static final class Ehcache {
            public static final int TIME_TO_LIVE_SECONDS = 3600; // 1 hour
            public static final long MAX_ENTRIES = 100;

            private Ehcache() {
                throw new IllegalStateException(DEFAULTS_CONSTANT_CLASS_EXCEPTION_MESSAGE);
            }
        }
    }

    public static final class ApiDocs {
        public static final String TITLE = "Application API";
        public static final String DESCRIPTION = "API documentation";
        public static final String VERSION = "0.0.1";
        public static final String TERMS_OF_SERVICE_URL = null;
        public static final String CONTACT_NAME = null;
        public static final String CONTACT_URL = null;
        public static final String CONTACT_EMAIL = null;
        public static final String LICENSE = null;
        public static final String LICENSE_URL = null;
        public static final String DEFAULT_INCLUDE_PATTERN = "/api/**";
        public static final String MANAGEMENT_INCLUDE_PATTERN = "/management/**";
        public static final String HOST = null;
        public static final String[] PROTOCOLS = {};
        public static final boolean USE_DEFAULT_RESPONSE_MESSAGES = true;

        private ApiDocs() {
            throw new IllegalStateException(DEFAULTS_CONSTANT_CLASS_EXCEPTION_MESSAGE);
        }
    }

    public static final class Metrics {
        private Metrics() {
            throw new IllegalStateException(DEFAULTS_CONSTANT_CLASS_EXCEPTION_MESSAGE);
        }

        public static final class Jmx {
            public static final boolean ENABLED = false;

            private Jmx() {
                throw new IllegalStateException(DEFAULTS_CONSTANT_CLASS_EXCEPTION_MESSAGE);
            }
        }

        public static final class Logs {
            public static final boolean ENABLED = false;
            public static final long REPORT_FREQUENCY = 60;

            private Logs() {
                throw new IllegalStateException(DEFAULTS_CONSTANT_CLASS_EXCEPTION_MESSAGE);
            }

        }

        public static final class Prometheus {
            public static final boolean ENABLED = false;
            public static final String ENDPOINT = "/prometheusMetrics";

            private Prometheus() {
                throw new IllegalStateException(DEFAULTS_CONSTANT_CLASS_EXCEPTION_MESSAGE);
            }
        }
    }

    public static final class Logging {
        public static final boolean USE_JSON_FORMAT = false;

        private Logging() {
            throw new IllegalStateException(DEFAULTS_CONSTANT_CLASS_EXCEPTION_MESSAGE);
        }

        public static final class Logstash {
            public static final boolean ENABLED = false;
            public static final String HOST = "localhost";
            public static final int PORT = 5000;
            public static final int RING_BUFFER_SIZE = 512;

            private Logstash() {
                throw new IllegalStateException(DEFAULTS_CONSTANT_CLASS_EXCEPTION_MESSAGE);
            }
        }
    }

    public static final class AuditEvents {
        public static final int RETENTION_PERIOD = 30;

        private AuditEvents() {
            throw new IllegalStateException(DEFAULTS_CONSTANT_CLASS_EXCEPTION_MESSAGE);
        }
    }
}
