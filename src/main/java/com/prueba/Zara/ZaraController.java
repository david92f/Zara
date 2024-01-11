package com.prueba.Zara;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZaraController {

	@GetMapping("/")
//	TODO: Acepte como parámetros de entrada: fecha de aplicación, identificador de producto, identificador de cadena.
	public String getPrices(Date startDate, Long productId, Long brandId) {
		
//		TODO: Devuelva como datos de salida: identificador de producto, identificador de cadena, tarifa a aplicar, fechas de aplicación y precio final a aplicar.
		return "OK";
		
	}
	
}
