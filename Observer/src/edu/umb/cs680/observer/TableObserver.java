package edu.umb.cs680.observer;

public class TableObserver implements Observer<StockEvent>{
    @Override
    public void update(Observable<StockEvent> sender, StockEvent stockEvent) {
        DataWarehouse.updateTableDataHistory(stockEvent);
        System.out.println("Table for ticker " + stockEvent.getTicker() + " updated to " + stockEvent.getQuote());
    }
}
