package com.prueba.zara.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.zara.dto.PriceDTO;
import com.prueba.zara.modelo.Price;
import com.prueba.zara.repositorio.PriceRepository;
import com.prueba.zara.service.PriceService;

@Service("priceService")
public class PriceServiceImpl implements PriceService {

	private final PriceRepository pricesRepository;

	@Autowired
	public PriceServiceImpl(PriceRepository pricesRepository) {
		this.pricesRepository = pricesRepository;
	}

	public Optional<PriceDTO> getPrices(Long brandId, Long productId, LocalDateTime applyDate) {
		List<Price> prices = pricesRepository
				.findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(brandId, productId,
						applyDate, applyDate);

		return prices.stream().findFirst().map(this::convertToDTO);
	}

	private PriceDTO convertToDTO(Price price) {
		return new PriceDTO(price.getBrandId(), price.getStartDate(), price.getEndDate(), price.getPriceList(),
				price.getProductId(), price.getPrice());
	}

}
