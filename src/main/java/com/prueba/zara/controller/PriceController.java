package com.prueba.zara.controller;

import com.prueba.zara.dto.PriceDTO;
import com.prueba.zara.service.PriceService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/prices")
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/{brandId}/{productId}")
    public ResponseEntity<PriceDTO> getPriceDTO(
            @PathVariable Long brandId,
            @PathVariable Long productId,
            @RequestParam("applyDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime applyDate) {

        return priceService.getPrices(brandId, productId, applyDate)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}