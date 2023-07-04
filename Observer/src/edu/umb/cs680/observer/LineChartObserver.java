package edu.umb.cs680.observer;

import javax.xml.crypto.Data;

public class LineChartObserver implements Observer<StockEvent>{
    @Override
    public void update(Observable<StockEvent> sender, StockEvent stockEvent) {
        DataWarehouse.updateLineChartDataHistory(stockEvent);
        System.out.println("Line chart for ticker " + stockEvent.getTicker() + " updated to " + stockEvent.getQuote());
    }
}
