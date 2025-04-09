package com.prueba.zara.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PriceResponseDto(
        @NotNull Long productId,
        @NotNull Long brandId,
        @NotNull Long priceList,
        @NotNull LocalDateTime startDate,
        @NotNull LocalDateTime endDate,
        @NotNull BigDecimal price
) {
}