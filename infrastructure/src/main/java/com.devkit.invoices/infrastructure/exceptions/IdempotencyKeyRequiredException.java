package com.devkit.invoices.infrastructure.exceptions;

import com.devkit.invoices.domain.exceptions.DomainException;

import java.util.Collections;

public class IdempotencyKeyRequiredException extends DomainException {

    public IdempotencyKeyRequiredException() {
        super("Idempotency key required and the required header is 'x-idempotency-key'", Collections.emptyList());
    }
}
