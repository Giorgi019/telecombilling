package com.giorgi.telecombilling.dto;

import java.math.BigDecimal;

public record TariffResponse(
        Long id,
        String name,
        BigDecimal monthlyFee,
        int includedMinutes
) {
}
