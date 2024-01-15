package com.prueba.Zara.endpoints;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.Zara.service.PricesService;

@RestController
public class PricesController {

	@Autowired
	private PricesService pricesService;
	
	@RequestMapping("/api/prices")
//	Acepte como parámetros de entrada: fecha de aplicación, identificador de producto, identificador de cadena.
	public String getPrices(Timestamp fecha, Long productId, Long brandId) {
		
		return pricesService.getPrices(fecha);
	}
	
}
