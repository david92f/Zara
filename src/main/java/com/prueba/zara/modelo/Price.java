package com.prueba.zara.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "PRICES")
public class Prices {

    @Id
    private Long priceList;

    private Long brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long productId;
    private Integer priority;
    private BigDecimal price;
    private String curr;
}
