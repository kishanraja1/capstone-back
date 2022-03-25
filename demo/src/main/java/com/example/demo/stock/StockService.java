package com.example.demo.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public void addNewStock(Stock stock) {
        Optional<Stock> stockByTicker = stockRepository
                .findStockByTicker(stock.getTicker());
        if (stockByTicker.isPresent()){
            throw new IllegalStateException("stock already exists. Please search to edit");
        }
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

    public void updateStock(){

    }
}
