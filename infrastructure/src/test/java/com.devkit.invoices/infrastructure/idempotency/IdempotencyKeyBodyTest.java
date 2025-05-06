package com.devkit.invoices.infrastructure.idempotency;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.devkit.invoices.infrastructure.configurations.xss.SanitizeUtils;

import java.io.Serializable;

public class IdempotencyKeyBodyTest implements Serializable {

    @JsonProperty("id")
    private String id;

    public IdempotencyKeyBodyTest() {
    }

    public IdempotencyKeyBodyTest(final String id) {
        this.id = SanitizeUtils.sanitize(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
