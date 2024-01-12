package com.prueba.Zara.endpoints;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.Zara.service.PricesService;

@RestController
public class PricesController {

	@Autowired
	private PricesService pricesService;
	
//	@GetMapping("/")
	@RequestMapping("/api/prices")
//	TODO: Acepte como parámetros de entrada: fecha de aplicación, identificador de producto, identificador de cadena.
	public String getPrices(Timestamp startDate, Long productId, Long brandId) {
		
		return pricesService.getPrices(productId);
	}
	
}
