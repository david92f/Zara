package com.prueba.zara.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "PRICES")
public class Prices {
	// Atributos y anotaciones JPA para mapear los campos de la tabla

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
