package com.giorgi.telecombilling.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record TariffRequest(

        @NotBlank
        String name,

        @NotNull
        @Positive
        BigDecimal monthlyFee,

        @NotNull
        @PositiveOrZero
        Integer includedMinutes
) {
}
