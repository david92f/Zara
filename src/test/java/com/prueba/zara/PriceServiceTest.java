package com.prueba.zara;

import com.prueba.zara.modelo.Prices;
import com.prueba.zara.repositorio.PricesRepository;
import com.prueba.zara.service.impl.PricesServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class PriceServiceTest {

    @Mock
    private PricesRepository pricesRepository;

    @InjectMocks
    private PricesServiceImpl pricesServiceImpl;

    @Test
    void testFindPriceMorning() {
        Long brandId = 1L;
        Long productId = 35455L;
        LocalDateTime applyDate = LocalDateTime.of(2020, 6, 14, 10, 0);

        Prices priceEntity = new Prices();
        priceEntity.setPrice(new BigDecimal("35.50"));

        when(pricesRepository
                .findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
                        brandId, productId, applyDate, applyDate
                )).thenReturn(Collections.singletonList(priceEntity));

        BigDecimal result = pricesServiceImpl.getPrices(brandId, productId, applyDate).get().price();

        assertEquals(new BigDecimal("35.50"), result);
    }

    @Test
    void testFindPriceAfternoon() {
        Long brandId = 1L;
        Long productId = 35455L;
        LocalDateTime applyDate = LocalDateTime.of(2020, 6, 14, 16, 0);

        Prices priceEntity = new Prices();
        priceEntity.setPrice(new BigDecimal("25.45"));

        when(pricesRepository
                .findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
                        brandId, productId, applyDate, applyDate
                )).thenReturn(Collections.singletonList(priceEntity));

        BigDecimal result = pricesServiceImpl.getPrices(brandId, productId, applyDate).get().price();

        assertEquals(new BigDecimal("25.45"), result);
    }

    @Test
    void testFindPriceEvening() {
        Long brandId = 1L;
        Long productId = 35455L;
        LocalDateTime applyDate = LocalDateTime.of(2020, 6, 14, 21, 0);

        Prices priceEntity = new Prices();
        priceEntity.setPrice(new BigDecimal("35.50"));

        when(pricesRepository
                .findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
                        brandId, productId, applyDate, applyDate
                )).thenReturn(Collections.singletonList(priceEntity));

        BigDecimal result = pricesServiceImpl.getPrices(brandId, productId, applyDate).get().price();

        assertEquals(new BigDecimal("35.50"), result);
    }

    @Test
    void testFindPriceNextDayMorning() {
        Long brandId = 1L;
        Long productId = 35455L;
        LocalDateTime applyDate = LocalDateTime.of(2020, 6, 15, 10, 0);

        Prices priceEntity = new Prices();
        priceEntity.setPrice(new BigDecimal("30.50"));

        when(pricesRepository
                .findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
                        brandId, productId, applyDate, applyDate
                )).thenReturn(Collections.singletonList(priceEntity));

        BigDecimal result = pricesServiceImpl.getPrices(brandId, productId, applyDate).get().price();

        assertEquals(new BigDecimal("30.50"), result);
    }

    @Test
    void testFindPriceNextDayEvening() {
        Long brandId = 1L;
        Long productId = 35455L;
        LocalDateTime applyDate = LocalDateTime.of(2020, 6, 16, 21, 0);

        Prices priceEntity = new Prices();
        priceEntity.setPrice(new BigDecimal("38.95"));

        when(pricesRepository
                .findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
                        brandId, productId, applyDate, applyDate
                )).thenReturn(Collections.singletonList(priceEntity));

        BigDecimal result = pricesServiceImpl.getPrices(brandId, productId, applyDate).get().price();

        assertEquals(new BigDecimal("38.95"), result);
    }
}
