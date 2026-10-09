package com.giorgi.telecombilling.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record InvoiceRequest(
        @NotNull
        Long subscriberId,

        @NotBlank
        String month,

        @NotNull
        @PositiveOrZero
        int usedMinutes
) {
}
