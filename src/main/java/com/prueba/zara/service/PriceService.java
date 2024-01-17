package com.prueba.zara.service;

import java.time.LocalDateTime;
import java.util.Optional;

import com.prueba.zara.dto.PriceDTO;

public interface PriceService {

	public Optional<PriceDTO> getPrices(Long brandId, Long productId, LocalDateTime applyDate);
	
}
