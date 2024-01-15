package com.prueba.zara;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prueba.zara.endpoints.PricesController;
import com.prueba.zara.modelo.Prices;
import com.prueba.zara.repositorio.PricesRepository;
import com.prueba.zara.service.PricesService;
import com.prueba.zara.service.impl.PricesServiceImpl;

@SpringBootTest
class PricesControllerTest {

	@Mock
    private PricesRepository pricesRepository;

    @InjectMocks
    private PricesServiceImpl pricesServiceImpl;

    @Test
    void test1() {
        Long brandId = 1L;
        Long productId = 35455L;
        LocalDateTime applyDate = LocalDateTime.of(2020, 6, 14, 10, 0);

        Prices prices = new Prices();
        prices.setPrice(new BigDecimal("35.50"));

        when(pricesRepository.findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
                brandId, productId, applyDate, applyDate)).thenReturn(Collections.singletonList(prices));

        Optional<BigDecimal> result = pricesServiceImpl.getPrices(brandId, productId, applyDate);

        assertEquals(new BigDecimal("35.50"), result.orElse(null));
    }
	
    @Test
    void test2() {
        Long brandId = 1L;
        Long productId = 35455L;
        LocalDateTime applyDate = LocalDateTime.of(2020, 6, 14, 16, 0);

        Prices prices = new Prices();
        prices.setPrice(new BigDecimal("25.45"));

        when(pricesRepository.findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
                brandId, productId, applyDate, applyDate)).thenReturn(Collections.singletonList(prices));

        Optional<BigDecimal> result = pricesServiceImpl.getPrices(brandId, productId, applyDate);

        assertEquals(new BigDecimal("25.45"), result.orElse(null));
    }
	
    @Test
    void test3() {
        Long brandId = 1L;
        Long productId = 35455L;
        LocalDateTime applyDate = LocalDateTime.of(2020, 6, 14, 21, 0);

        Prices prices = new Prices();
        prices.setPrice(new BigDecimal("35.50"));

        when(pricesRepository.findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
                brandId, productId, applyDate, applyDate)).thenReturn(Collections.singletonList(prices));

        Optional<BigDecimal> result = pricesServiceImpl.getPrices(brandId, productId, applyDate);

        assertEquals(new BigDecimal("35.50"), result.orElse(null));
    }
    
    @Test
    void test4() {
        Long brandId = 1L;
        Long productId = 35455L;
        LocalDateTime applyDate = LocalDateTime.of(2020, 6, 15, 10, 0);

        Prices prices = new Prices();
        prices.setPrice(new BigDecimal("30.50"));

        when(pricesRepository.findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
                brandId, productId, applyDate, applyDate)).thenReturn(Collections.singletonList(prices));

        Optional<BigDecimal> result = pricesServiceImpl.getPrices(brandId, productId, applyDate);

        assertEquals(new BigDecimal("30.50"), result.orElse(null));
    }
    
    @Test
    void test5() {
        Long brandId = 1L;
        Long productId = 35455L;
        LocalDateTime applyDate = LocalDateTime.of(2020, 6, 16, 21, 0);

        Prices prices = new Prices();
        prices.setPrice(new BigDecimal("38.95"));

        when(pricesRepository.findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
                brandId, productId, applyDate, applyDate)).thenReturn(Collections.singletonList(prices));

        Optional<BigDecimal> result = pricesServiceImpl.getPrices(brandId, productId, applyDate);

        assertEquals(new BigDecimal("38.95"), result.orElse(null));
    }

}
