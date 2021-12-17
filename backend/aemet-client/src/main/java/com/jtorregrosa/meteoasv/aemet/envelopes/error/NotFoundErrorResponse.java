package com.jtorregrosa.meteoasv.aemet.envelopes.error;

public class NotFoundErrorResponse extends ErrorResponse {
    public NotFoundErrorResponse(String description, int status) {
        super(description, status);
    }
}
