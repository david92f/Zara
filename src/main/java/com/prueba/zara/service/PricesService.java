package com.prueba.zara.service;

import java.time.LocalDateTime;
import java.util.Optional;

import com.prueba.zara.modelo.Prices;

public interface PricesService {

	public Optional<Prices> getPrices(Long brandId, Long productId, LocalDateTime applyDate);
	
}
