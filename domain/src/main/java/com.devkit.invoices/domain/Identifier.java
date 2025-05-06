package com.devkit.invoices.domain;

public interface Identifier<T> extends ValueObject {

    T value();
}
