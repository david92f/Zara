package com.prueba.zara.controller;

import com.prueba.zara.dto.PriceResponseDto;
import com.prueba.zara.service.PricesService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/prices")
public class PricesController {

    private final PricesService pricesService;

    public PricesController(PricesService pricesService) {
        this.pricesService = pricesService;
    }

    @GetMapping("/{brandId}/{productId}")
    public ResponseEntity<PriceResponseDto> getPrice(
            @PathVariable Long brandId,
            @PathVariable Long productId,
            @RequestParam("applyDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime applyDate) {

        return pricesService.getPrices(brandId, productId, applyDate)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}