package com.prueba.Zara.modelo;

import java.util.Date;

import jakarta.persistence.Column;
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
	@Column(name="PRICE_LIST")
	private Long priceList;
	
	@Column(name="PRODUCT_ID")
	private Long productId;
	
	@Column(name="START_DATE")
	private Date startDate;
	
	@Column(name="END_DATE")
	private Date endDate;
	
	@Column(name="BRAND_ID")
	private Long brandId;
	
	@Column(name="PRIORITY")
	private Long priority;
	
	@Column(name="PRICE")
	private Float price;
	
	@Column(name="CURR")
	private String curr;
	
}

