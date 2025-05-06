package com.devkit.invoices.infrastructure.exceptions;

import com.devkit.invoices.domain.exceptions.DomainException;

import java.util.Collections;

public class IdempotencyKeyAlreadyExistsException extends DomainException {

    public IdempotencyKeyAlreadyExistsException() {
        super("Idempotency key already exists", Collections.emptyList());
    }
}
