package com.devkit.invoices.infrastructure.exceptions;

import com.devkit.invoices.domain.exceptions.NoStackTraceException;

public class IdempotencyKeyUnsupportedMethodException extends NoStackTraceException {

    public IdempotencyKeyUnsupportedMethodException(final String method) {
        super("Idempotency key is not supported for this method: " + method);
    }
}
