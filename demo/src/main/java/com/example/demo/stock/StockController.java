package com.example.demo.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/stocks")
@CrossOrigin(origins = "*")
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }


    @GetMapping
    public List<Stock> getStocks() {
        return stockService.getStocks();
    }

    @GetMapping(path = "{stockId}")
    public void getStock(@PathVariable("stockId") Long stockId){
        stockService.getStock(stockId);
    }

    @PostMapping
    public void registerNewStock(@RequestBody Stock stock){
        stockService.addNewStock(stock);
    }

    @DeleteMapping(path = "{stockId}")
    public void deleteStock(@PathVariable("stockId") Long stockId){
        stockService.deleteStock(stockId);
    }

    @PutMapping(path = "{stockId}")
    public void updateStock(
            @PathVariable("stockId") Long stockId,
            @RequestBody(required = false) Stock stockData){
            stockService.updateStock(stockId, stockData);
    }



}
