package com.devkit.invoices;

import com.devkit.invoices.infrastructure.configurations.OtelConfig;
import com.devkit.invoices.infrastructure.configurations.SecurityConfig;
import com.devkit.invoices.infrastructure.idempotency.gateways.InMemoryIdempotencyKeyGateway;
import com.devkit.invoices.infrastructure.utils.ObservationHelper;
import org.junit.jupiter.api.Tag;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@ActiveProfiles("test-integration")
@WebMvcTest
@TestPropertySource(properties = "application.otel.memory-exporter=true")
@Import({ SecurityConfig.class, IntegrationTestConfig.class, OtelConfig.class, InMemoryIdempotencyKeyGateway.class, ObservationHelper.class })
@Tag("integrationTest")
public @interface ControllerTest {

    @AliasFor(annotation = WebMvcTest.class, attribute = "controllers")
    Class<?>[] controllers() default {};
}
