package com.example.demo.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository
        extends JpaRepository<Stock, Long> {

    @Query("SELECT s FROM Stock s WHERE s.ticker = ?1")
    Optional<Stock> findStockByTicker(String ticker);

    @Query("SELECT s FROM Stock s WHERE s.id = ?1")
    Optional<Stock> findStockById(Long stockId);
}
