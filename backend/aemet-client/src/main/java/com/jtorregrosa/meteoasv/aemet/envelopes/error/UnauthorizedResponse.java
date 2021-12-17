package com.jtorregrosa.meteoasv.aemet.envelopes.error;

public class UnauthorizedResponse extends ErrorResponse {
    public UnauthorizedResponse(String description, int status) {
        super(description, status);
    }
}
