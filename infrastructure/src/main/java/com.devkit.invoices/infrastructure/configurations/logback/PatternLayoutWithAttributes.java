package com.devkit.invoices.infrastructure.configurations.logback;

import ch.qos.logback.classic.PatternLayout;

public class PatternLayoutWithAttributes extends PatternLayout {

    static {
        PatternLayout.DEFAULT_CONVERTER_MAP.put("user", UserLogConverter.class.getName());
    }
}
