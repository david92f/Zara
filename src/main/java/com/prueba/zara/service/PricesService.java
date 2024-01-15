package com.prueba.zara.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

public interface PricesService {

	public Optional<BigDecimal> getPrices(Long brandId, Long productId, LocalDateTime applyDate);
	
}
