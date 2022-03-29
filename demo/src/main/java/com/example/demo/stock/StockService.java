package com.example.demo.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StockService {

    private final StockRepository stockRepository;

    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }


    public List<Stock> getStocks() {
        return stockRepository.findAll();
    }

    public void getStock(Long stockId) {
        boolean stockExists = stockRepository.existsById(stockId);
        if (!stockExists){
            throw new IllegalStateException(
                    "stock with id " + stockId + " does not exist");
        }
        stockRepository.findStockById(stockId);
    }

    public void addNewStock(Stock stock) {
        Optional<Stock> stockByTicker = stockRepository
                .findStockByTicker(stock.getTicker());
        stockRepository.save(stock);

        System.out.println(stock);
    }

    public void deleteStock(Long stockId) {
            boolean exists = stockRepository.existsById(stockId);
            if (!exists){
                throw new IllegalStateException(
                        "stock with id " + stockId + " does not exist");
            }
            stockRepository.deleteById(stockId);
    }


    @Transactional
    public void updateStock(Long stockId, Stock stockData){
        stockData.setId((stockId));
        stockRepository.save(stockData);
    }

}
