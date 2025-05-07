package com.devkit.invoices.infrastructure.rest.controllers;

import com.devkit.invoices.domain.utils.InstantUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/ping")
public class Ping {

    private static final Logger log = LoggerFactory.getLogger(Ping.class);

    @GetMapping
    public ResponseEntity<?> pong() {
        log.info("pong");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Pong", InstantUtils.now().toString()));
    }
}
