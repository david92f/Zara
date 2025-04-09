package com.prueba.zara.service;

import com.prueba.zara.dto.PriceResponseDto;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PricesService {
    Optional<PriceResponseDto> getPrices(Long brandId, Long productId, LocalDateTime applyDate);
}
