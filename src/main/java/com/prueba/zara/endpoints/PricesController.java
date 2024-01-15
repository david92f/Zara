package com.prueba.zara.endpoints;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.zara.service.PricesService;

@RestController
public class PricesController {
	private PricesService pricesService;

	@Autowired
	public PricesController(PricesService priceService) {
		this.pricesService = priceService;
	}

	@GetMapping("/price/{brandId}/{productId}")
	public ResponseEntity<String> getPrice(@PathVariable Long brandId, @PathVariable Long productId,
			@RequestParam("applyDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime applyDate) {

		Optional<BigDecimal> price = pricesService.getPrices(brandId, productId, applyDate);

		return price.map(value -> ResponseEntity.ok("Precio encontrado: " + value))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

}
