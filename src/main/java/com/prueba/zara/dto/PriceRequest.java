package com.prueba.zara.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PriceRequest(
        @NotNull(message = "El identificador del producto es obligatorio")
        Long productId,

        @NotNull(message = "El identificador de la marca es obligatorio")
        Long brandId,

        @NotNull(message = "La fecha de aplicación es obligatoria")
        LocalDateTime applyDate,

        @Positive(message = "El precio debe ser mayor que cero")
        BigDecimal price
) {
}
