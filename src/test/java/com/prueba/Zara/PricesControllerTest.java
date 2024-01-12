package com.prueba.Zara;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prueba.Zara.endpoints.PricesController;

@SpringBootTest
class PricesControllerTest {

	@Autowired
	private PricesController controller;
	
	@Test
	void test1() {
		// Formato de la fecha y hora
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Timestamp timestamp = null;
        try {
            // Parsear la cadena de fecha y hora
            Date parsedDate = dateFormat.parse("2020-06-14 00:00:00");

            // Crear un objeto Timestamp a partir de la fecha parseada
            timestamp = new Timestamp(parsedDate.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }
        
		Assertions.assertNotNull(controller.getPrices(timestamp, 35455L, 1L));
	}
	
	@Test
	void test2() {
		
	}
	
	@Test
	void test3() {
		
	}
	
	@Test
	void test4() {
		
	}
	
	@Test
	void test5() {
		
	}

}
