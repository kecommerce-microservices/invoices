package com.devkit.invoices.infrastructure.utils;

import com.devkit.invoices.domain.UnitTest;
import com.devkit.invoices.domain.exceptions.DomainException;
import com.devkit.invoices.domain.utils.InstantUtils;
import com.devkit.invoices.domain.validation.Error;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ApiErrorTest extends UnitTest {

    @Test
    void givenAValidDomainException_whenCallFrom_shouldReturnMessageAndErrorList() {
        final var aErrors = List.of(new Error("Error 1"), new Error("Error 2"));
        final var aDomainException = DomainException.with(aErrors);
        final var aNow = InstantUtils.now();

        final var aResult = ApiError.from(aDomainException, aNow);

        Assertions.assertEquals(aDomainException.getMessage(), aResult.message());
        Assertions.assertEquals(aErrors, aResult.errors());
        Assertions.assertEquals(aNow, aResult.timestamp());
    }

    @Test
    void givenAValidMessage_whenCallFrom_shouldReturnMessageAndEmptyErrorList() {
        final var aMessage = "Internal Server Error";
        final var aNow = InstantUtils.now();

        final var aResult = ApiError.from(aMessage, aNow);

        Assertions.assertEquals(aMessage, aResult.message());
        Assertions.assertEquals(0, aResult.errors().size());
        Assertions.assertEquals(aNow, aResult.timestamp());
    }
}
