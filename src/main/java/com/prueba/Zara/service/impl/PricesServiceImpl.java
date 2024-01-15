package com.prueba.Zara.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.Zara.modelo.Prices;
import com.prueba.Zara.repositorio.PricesRepository;
import com.prueba.Zara.service.PricesService;

@Service("PricesService")
public class PricesServiceImpl implements PricesService {

	@Autowired
	private PricesRepository pricesRepository;
	
//	Devuelva como datos de salida: identificador de producto, identificador de cadena, tarifa a aplicar, fechas de aplicación y precio final a aplicar.
	@Override
	public String getPrices(Long id) {
		Optional<Prices> optional = pricesRepository.findById(id.intValue());
		
		return "petición a las 10:00 del día 14 del producto 35455 para la brand 1";
	}

	
}
