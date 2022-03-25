package com.example.demo.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    @Transactional
    public void updateStock(Long stockId, String headline, String name, String ticker, Double price, String industry, String opinion){
        Stock stock = stockRepository.findStockById(stockId)
                .orElseThrow(() -> new IllegalStateException(
                        "stock with id " + stockId + " does not exist"));

        if (headline != null &&
                headline.length() > 0 &&
                !Objects.equals(stock.getHeadline(), headline)) {
            stock.setHeadline(headline);
        }

        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(stock.getName(), name)) {
            stock.setName(name);
        }

        if (ticker != null &&
                ticker.length() > 0 &&
                !Objects.equals(stock.getTicker(), ticker)) {
            stock.setTicker(ticker);
        }

        if (price != null &&
                !Objects.equals(stock.getPrice(), price)) {
            stock.setPrice(price);
        }

        if (industry != null &&
                industry.length() > 0 &&
                !Objects.equals(stock.getIndustry(), industry)) {
            stock.setIndustry(industry);
        }

        if (opinion != null &&
                opinion.length() > 0 &&
                !Objects.equals(stock.getOpinion(), opinion)) {
            stock.setOpinion(opinion);
        }

    }

}
