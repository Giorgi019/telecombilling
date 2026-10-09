package com.giorgi.telecombilling.dto;

import java.math.BigDecimal;

public record InvoiceResponse(
        Long id,
        Long subscriberId,
        String month,
        BigDecimal totalAmount,
        int usedMinutes,
        boolean paid
) {
}
