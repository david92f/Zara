package com.prueba.zara.service.impl;

import com.prueba.zara.dto.PriceResponseDto;
import com.prueba.zara.modelo.Prices;
import com.prueba.zara.repositorio.PricesRepository;
import com.prueba.zara.service.PricesService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PricesServiceImpl implements PricesService {

    private final PricesRepository pricesRepository;

    public PricesServiceImpl(PricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }

    @Override
    public Optional<PriceResponseDto> getPrices(Long brandId, Long productId, LocalDateTime applyDate) {
        List<Prices> prices = pricesRepository
                .findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
                        brandId, productId, applyDate, applyDate);

        return prices.stream()
                .findFirst()
                .map(p -> new PriceResponseDto(
                        p.getProductId(),
                        p.getBrandId(),
                        p.getPriceList(),
                        p.getStartDate(),
                        p.getEndDate(),
                        p.getPrice()
                ));
    }
}