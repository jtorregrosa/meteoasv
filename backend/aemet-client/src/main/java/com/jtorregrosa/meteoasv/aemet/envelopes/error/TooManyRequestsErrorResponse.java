package com.jtorregrosa.meteoasv.aemet.envelopes.error;

public class TooManyRequestsErrorResponse extends ErrorResponse {
    public TooManyRequestsErrorResponse(String description, int status) {
        super(description, status);
    }
}
