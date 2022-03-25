package com.example.demo.stock;

import javax.persistence.*;

@Entity
@Table
public class Stock {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "student_sequence"
    )
    private Long id;
    private String headline;
    private String name;
    private String ticker;
    private Double price;
    private String industry;
    private String opinion;


    public Stock() {
    }

    public Stock(Long id,
                 String headline,
                 String name,
                 String ticker,
                 Double price,
                 String industry,
                 String opinion) {
        this.id = id;
        this.headline = headline;
        this.name = name;
        this.ticker = ticker;
        this.price = price;
        this.industry=industry;
        this.opinion = opinion;
    }

    public Stock(String headline,
                 String name,
                 String ticker,
                 Double price,
                 String industry,
                 String opinion) {
        this.headline = headline;
        this.name = name;
        this.ticker = ticker;
        this.price = price;
        this.industry = industry;
        this.opinion = opinion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }


    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", headline='" + headline + '\'' +
                ", name='" + name + '\'' +
                ", ticker='" + ticker + '\'' +
                ", price=" + price +
                ", industry='" + industry + '\'' +
                ", opinion='" + opinion + '\'' +
                '}';
    }
}
