package edu.umb.cs680.observer;

import java.time.LocalDateTime;

public class StockEvent {
    private String ticker;
    private double quote;
    private LocalDateTime datetime;

    public StockEvent(String t, double q){
        this.ticker = t;
        this.quote = q;
        this.datetime = LocalDateTime.now();
    }

    public String getTicker() {
        return ticker;
    }

    public double getQuote() {
        return quote;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }
}
