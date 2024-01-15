package com.prueba.zara;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.prueba.zara.modelo.Prices;
import com.prueba.zara.repositorio.PricesRepository;
import com.prueba.zara.service.impl.PricesServiceImpl;

@SpringBootTest
class PriceServiceTest {

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

		when(pricesRepository.findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(brandId,
				productId, applyDate, applyDate)).thenReturn(Collections.singletonList(prices));

		BigDecimal result = pricesServiceImpl.getPrices(brandId, productId, applyDate).get().getPrice();

		assertEquals(new BigDecimal("35.50"), result);
	}

	@Test
	void test2() {
		Long brandId = 1L;
		Long productId = 35455L;
		LocalDateTime applyDate = LocalDateTime.of(2020, 6, 14, 16, 0);

		Prices prices = new Prices();
		prices.setPrice(new BigDecimal("25.45"));

		when(pricesRepository.findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(brandId,
				productId, applyDate, applyDate)).thenReturn(Collections.singletonList(prices));

		BigDecimal result = pricesServiceImpl.getPrices(brandId, productId, applyDate).get().getPrice();

		assertEquals(new BigDecimal("25.45"), result);
	}

	@Test
	void test3() {
		Long brandId = 1L;
		Long productId = 35455L;
		LocalDateTime applyDate = LocalDateTime.of(2020, 6, 14, 21, 0);

		Prices prices = new Prices();
		prices.setPrice(new BigDecimal("35.50"));

		when(pricesRepository.findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(brandId,
				productId, applyDate, applyDate)).thenReturn(Collections.singletonList(prices));

		BigDecimal result = pricesServiceImpl.getPrices(brandId, productId, applyDate).get().getPrice();

		assertEquals(new BigDecimal("35.50"), result);
	}

	@Test
	void test4() {
		Long brandId = 1L;
		Long productId = 35455L;
		LocalDateTime applyDate = LocalDateTime.of(2020, 6, 15, 10, 0);

		Prices prices = new Prices();
		prices.setPrice(new BigDecimal("30.50"));

		when(pricesRepository.findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(brandId,
				productId, applyDate, applyDate)).thenReturn(Collections.singletonList(prices));

		BigDecimal result = pricesServiceImpl.getPrices(brandId, productId, applyDate).get().getPrice();

		assertEquals(new BigDecimal("30.50"), result);
	}

	@Test
	void test5() {
		Long brandId = 1L;
		Long productId = 35455L;
		LocalDateTime applyDate = LocalDateTime.of(2020, 6, 16, 21, 0);

		Prices prices = new Prices();
		prices.setPrice(new BigDecimal("38.95"));

		when(pricesRepository.findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(brandId,
				productId, applyDate, applyDate)).thenReturn(Collections.singletonList(prices));

		BigDecimal result = pricesServiceImpl.getPrices(brandId, productId, applyDate).get().getPrice();

		assertEquals(new BigDecimal("38.95"), result);
	}

}
