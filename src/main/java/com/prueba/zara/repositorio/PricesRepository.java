package com.prueba.zara.repositorio;

import com.prueba.zara.modelo.Prices;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PricesRepository extends JpaRepository<Prices, Integer> {

    List<Prices> findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
    		Long brandId, Long productId, LocalDateTime startDate, LocalDateTime endDate);
    
}
