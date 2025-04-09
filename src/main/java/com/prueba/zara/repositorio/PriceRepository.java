package com.prueba.zara.repositorio;

import com.prueba.zara.modelo.Prices;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PricesRepository extends JpaRepository<Prices, Long> {

    List<Prices> findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
            Long brandId, Long productId, LocalDateTime startDate, LocalDateTime endDate);
}
