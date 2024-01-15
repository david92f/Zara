package com.prueba.zara.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.zara.modelo.Prices;
import com.prueba.zara.repositorio.PricesRepository;
import com.prueba.zara.service.PricesService;

@Service("PricesService")
public class PricesServiceImpl implements PricesService {

	private final PricesRepository pricesRepository;

	@Autowired
	public PricesServiceImpl(PricesRepository pricesRepository) {
		this.pricesRepository = pricesRepository;
	}

	public Optional<Prices> getPrices(Long brandId, Long productId, LocalDateTime applyDate) {
		List<Prices> prices = pricesRepository
				.findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(brandId, productId,
						applyDate, applyDate);

		return prices.stream().findFirst();
	}

}
