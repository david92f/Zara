package com.prueba.Zara.repositorio;

import com.prueba.Zara.modelo.Prices;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PricesRepository extends JpaRepository<Prices, Integer> {

	@Query("SELECT P FROM Prices P ")
	public List<Prices> getPrices();
	
}
