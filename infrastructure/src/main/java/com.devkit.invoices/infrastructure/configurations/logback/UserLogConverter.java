package com.devkit.invoices.infrastructure.configurations.logback;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.devkit.invoices.infrastructure.configurations.authentication.AuthenticatedUser;
import com.devkit.invoices.infrastructure.configurations.authentication.UserAuthentication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserLogConverter extends ClassicConverter {

    @Override
    public String convert(final ILoggingEvent event) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication == null || !authentication.isAuthenticated()) {
                return "anonymous";
            }

            if (!(authentication.getPrincipal() instanceof UserAuthentication userAuth)) {
                return "unknown";
            }

            Object principal = userAuth.getPrincipal();
            if (principal instanceof AuthenticatedUser authenticatedUser) {
                return authenticatedUser.id(); // ou .getId() dependendo do tipo
            }

            return "unknown";
        } catch (Exception e) {
            return "error";
        }
    }
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication == null) {
//            return "anonymous"; // anonymous user
//        }
//
//        final var aUser = (UserAuthentication) authentication.getPrincipal();
//        final var aAuthenticatedUser = (AuthenticatedUser) aUser.getPrincipal();
//        return aAuthenticatedUser.id();
//    }
}
