package com.prueba.zara.service.impl;

import com.prueba.zara.dto.PriceDTO;
import com.prueba.zara.modelo.Price;
import com.prueba.zara.repositorio.PriceRepository;
import com.prueba.zara.service.PriceService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service("priceService")
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Optional<PriceDTO> getPrices(Long brandId, Long productId, LocalDateTime applyDate) {
        List<Price> prices = priceRepository
                .findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(brandId, productId,
                        applyDate, applyDate);

        return prices.stream().findFirst().map(this::convertToDTO);
    }

    private PriceDTO convertToDTO(Price price) {
        return new PriceDTO(price.getBrandId(), price.getStartDate(), price.getEndDate(), price.getPriceList(),
                price.getProductId(), price.getProductPrice());
    }

}
