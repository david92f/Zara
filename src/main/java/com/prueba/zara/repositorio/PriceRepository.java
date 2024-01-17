package com.prueba.zara.repositorio;

import com.prueba.zara.modelo.Price;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Integer> {

	List<Price> findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(Long brandId,
			Long productId, LocalDateTime startDate, LocalDateTime endDate);

}
