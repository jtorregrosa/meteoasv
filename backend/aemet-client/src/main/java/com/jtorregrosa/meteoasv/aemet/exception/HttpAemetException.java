package com.jtorregrosa.meteoasv.aemet.exception;

import java.security.PrivilegedActionException;

public class HttpAemetException extends Exception {
    /**
     * Http status code.
     */
    private final int statusCode;

    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param statusCode the status code.
     */
    public HttpAemetException(int statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param statusCode the status code.
     * @param message    the detail message. The detail message is saved for
     *                   later retrieval by the {@link #getMessage()} method.
     */
    public HttpAemetException(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    /**
     * Constructs a new exception with the specified detail message and
     * cause.  <p>Note that the detail message associated with
     * {@code cause} is <i>not</i> automatically incorporated in
     * this exception's detail message.
     *
     * @param statusCode the status code.
     * @param message    the detail message (which is saved for later retrieval
     *                   by the {@link #getMessage()} method).
     * @param cause      the cause (which is saved for later retrieval by the
     *                   {@link #getCause()} method).  (A {@code null} value is
     *                   permitted, and indicates that the cause is nonexistent or
     *                   unknown.)
     */
    public HttpAemetException(int statusCode, String message, Throwable cause) {
        super(message, cause);
        this.statusCode = statusCode;
    }

    /**
     * Constructs a new exception with the specified cause and a detail
     * message of {@code (cause==null ? null : cause.toString())} (which
     * typically contains the class and detail message of {@code cause}).
     * This constructor is useful for exceptions that are little more than
     * wrappers for other throwables (for example, {@link
     * PrivilegedActionException}).
     *
     * @param statusCode the status code.
     * @param cause      the cause (which is saved for later retrieval by the
     *                   {@link #getCause()} method).  (A {@code null} value is
     *                   permitted, and indicates that the cause is nonexistent or
     *                   unknown.)
     */
    public HttpAemetException(int statusCode, Throwable cause) {
        super(cause);
        this.statusCode = statusCode;
    }

    /**
     * Constructs a new exception with the specified detail message,
     * cause, suppression enabled or disabled, and writable stack
     * trace enabled or disabled.
     *
     * @param statusCode         the status code.
     * @param message            the detail message.
     * @param cause              the cause.  (A {@code null} value is permitted,
     *                           and indicates that the cause is nonexistent or unknown.)
     * @param enableSuppression  whether or not suppression is enabled
     *                           or disabled
     * @param writableStackTrace whether or not the stack trace should
     *                           be writable
     */
    public HttpAemetException(int statusCode, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.statusCode = statusCode;
    }
}
