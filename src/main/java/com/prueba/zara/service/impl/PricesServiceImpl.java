package com.prueba.zara.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.zara.modelo.Prices;
import com.prueba.zara.repositorio.PricesRepository;
import com.prueba.zara.service.PricesService;

@Service("PricesService")
public class PricesServiceImpl implements PricesService {

	// Obtén el logger
	private static final Logger logger = LoggerFactory.getLogger(PricesServiceImpl.class);

	private final PricesRepository pricesRepository;

	@Autowired
	public PricesServiceImpl(PricesRepository pricesRepository) {
		this.pricesRepository = pricesRepository;
	}

	public Optional<BigDecimal> getPrices(Long brandId, Long productId, LocalDateTime applyDate) {
		List<Prices> prices = pricesRepository
				.findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(brandId, productId,
						applyDate, applyDate);

		var precio = "Precio: " + prices.stream().findFirst().map(Prices::getPrice).orElse(new BigDecimal(0));
		logger.info(precio);

		return prices.stream().findFirst().map(Prices::getPrice);
	}

}
