package com.giorgi.telecombilling.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SubscriberRequest(

        @NotBlank
        String firstName,

        @NotBlank
        String lastName,

        @NotBlank
        String phoneNumber,

        @NotNull
        Long tariffId
) {
}
