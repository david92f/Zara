package com.prueba.zara;

import com.prueba.zara.modelo.Price;
import com.prueba.zara.dto.PriceDTO;
import com.prueba.zara.repositorio.PriceRepository;
import com.prueba.zara.service.impl.PriceServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
class PriceServiceTest {

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private PriceServiceImpl priceServiceImpl;

    @Test
    void testFindPriceMorning() {
        Long brandId = 1L;
        Long productId = 35455L;
        LocalDateTime applyDate = LocalDateTime.of(2020, 6, 14, 10, 0);

        Price priceEntity = new Price();
        priceEntity.setProductPrice(new BigDecimal("35.50"));

        when(priceRepository
                .findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
                        brandId, productId, applyDate, applyDate
                )).thenReturn(Collections.singletonList(priceEntity));

        // Corrected line for asserting the price from the Optional<PriceDTO>
        Optional<PriceDTO> optionalPriceDTO = priceServiceImpl.getPrices(brandId, productId, applyDate);

        // Assert that a value is present before trying to get it
        assertTrue(optionalPriceDTO.isPresent(), "PriceDTO should be present for this test case");

        // Get the PriceDTO and then the price
        BigDecimal result = optionalPriceDTO.get().getPrice();

        assertEquals(new BigDecimal("35.50"), result);
    }

    @Test
    void testFindPriceAfternoon() {
        Long brandId = 1L;
        Long productId = 35455L;
        LocalDateTime applyDate = LocalDateTime.of(2020, 6, 14, 16, 0);

        Price priceEntity = new Price();
        priceEntity.setProductPrice(new BigDecimal("25.45"));

        when(priceRepository
                .findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
                        brandId, productId, applyDate, applyDate
                )).thenReturn(Collections.singletonList(priceEntity));

        // Corrected line for asserting the price from the Optional<PriceDTO>
        Optional<PriceDTO> optionalPriceDTO = priceServiceImpl.getPrices(brandId, productId, applyDate);

        // Assert that a value is present before trying to get it
        assertTrue(optionalPriceDTO.isPresent(), "PriceDTO should be present for this test case");

        // Get the PriceDTO and then the price
        BigDecimal result = optionalPriceDTO.get().getPrice();

        assertEquals(new BigDecimal("25.45"), result);
    }

    @Test
    void testFindPriceEvening() {
        Long brandId = 1L;
        Long productId = 35455L;
        LocalDateTime applyDate = LocalDateTime.of(2020, 6, 14, 21, 0);

        Price priceEntity = new Price();
        priceEntity.setProductPrice(new BigDecimal("35.50"));

        when(priceRepository
                .findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
                        brandId, productId, applyDate, applyDate
                )).thenReturn(Collections.singletonList(priceEntity));

        // Corrected line for asserting the price from the Optional<PriceDTO>
        Optional<PriceDTO> optionalPriceDTO = priceServiceImpl.getPrices(brandId, productId, applyDate);

        // Assert that a value is present before trying to get it
        assertTrue(optionalPriceDTO.isPresent(), "PriceDTO should be present for this test case");

        // Get the PriceDTO and then the price
        BigDecimal result = optionalPriceDTO.get().getPrice();

        assertEquals(new BigDecimal("35.50"), result);
    }

    @Test
    void testFindPriceNextDayMorning() {
        Long brandId = 1L;
        Long productId = 35455L;
        LocalDateTime applyDate = LocalDateTime.of(2020, 6, 15, 10, 0);

        Price priceEntity = new Price();
        priceEntity.setProductPrice(new BigDecimal("30.50"));

        when(priceRepository
                .findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
                        brandId, productId, applyDate, applyDate
                )).thenReturn(Collections.singletonList(priceEntity));

        // Corrected line for asserting the price from the Optional<PriceDTO>
        Optional<PriceDTO> optionalPriceDTO = priceServiceImpl.getPrices(brandId, productId, applyDate);

        // Assert that a value is present before trying to get it
        assertTrue(optionalPriceDTO.isPresent(), "PriceDTO should be present for this test case");

        // Get the PriceDTO and then the price
        BigDecimal result = optionalPriceDTO.get().getPrice();

        assertEquals(new BigDecimal("30.50"), result);
    }

    @Test
    void testFindPriceNextDayEvening() {
        Long brandId = 1L;
        Long productId = 35455L;
        LocalDateTime applyDate = LocalDateTime.of(2020, 6, 16, 21, 0);

        Price priceEntity = new Price();
        priceEntity.setProductPrice(new BigDecimal("38.95"));

        when(priceRepository
                .findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
                        brandId, productId, applyDate, applyDate
                )).thenReturn(Collections.singletonList(priceEntity));

        // Corrected line for asserting the price from the Optional<PriceDTO>
        Optional<PriceDTO> optionalPriceDTO = priceServiceImpl.getPrices(brandId, productId, applyDate);

        // Assert that a value is present before trying to get it
        assertTrue(optionalPriceDTO.isPresent(), "PriceDTO should be present for this test case");

        // Get the PriceDTO and then the price
        BigDecimal result = optionalPriceDTO.get().getPrice();

        assertEquals(new BigDecimal("38.95"), result);
    }
}