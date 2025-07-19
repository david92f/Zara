package com.prueba.zara.service;

import com.prueba.zara.dto.PriceDTO;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceService {

    Optional<PriceDTO> getPrices(Long brandId, Long productId, LocalDateTime applyDate);

}
