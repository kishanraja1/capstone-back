package com.example.demo.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/stocks")
@CrossOrigin(origins = {"http://localhost:3000/", "https://fierce-retreat-92206.herokuapp.com/"})
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
            @RequestParam(required = false) String headline,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String ticker,
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) String industry,
            @RequestParam(required = false) String opinion){
        stockService.updateStock(stockId, headline, name, ticker, price, industry, opinion);
    }



}
