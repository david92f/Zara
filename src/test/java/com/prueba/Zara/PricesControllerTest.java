package com.prueba.Zara;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prueba.Zara.endpoints.PricesController;

@SpringBootTest
class PricesControllerTest {

	@Autowired
	private PricesController controller;
	@Autowired
	Logger logger;
	
	Timestamp getFecha(String fecha) {
		// Formato de la fecha y hora
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Timestamp timestamp = null;
        try {
            // Parsear la cadena de fecha y hora
            Date parsedDate = dateFormat.parse(fecha);

            // Crear un objeto Timestamp a partir de la fecha parseada
            timestamp = new Timestamp(parsedDate.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timestamp;
	}
	
	@Test
	void test1() {
		//Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
		String salida = controller.getPrices(getFecha("2020-06-14 10:00:00"), 35455L, 1L);
		logger.info(salida);
		Assertions.assertNotNull(salida);
	}
	
	@Test
	void test2() {
		//Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
		String salida = controller.getPrices(getFecha("2020-06-14 16:00:00"), 35455L, 1L);
		logger.info(salida);
		Assertions.assertNotNull(salida);
	}
	
	@Test
	void test3() {
		//Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
		String salida = controller.getPrices(getFecha("2020-06-14 21:00:00"), 35455L, 1L);
		logger.info(salida);
		Assertions.assertNotNull(salida);
	}
	
	@Test
	void test4() {
		//Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
		String salida = controller.getPrices(getFecha("2020-06-15 10:00:00"), 35455L, 1L);
		logger.info(salida);
		Assertions.assertNotNull(salida);
	}
	
	@Test
	void test5() {
		//Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
		String salida = controller.getPrices(getFecha("2020-06-16 21:00:00"), 35455L, 1L);
		logger.info(salida);
		Assertions.assertNotNull(salida);
	}

}
