package edu.umb.cs680.observer;

public interface Observer<StockEvent> {
	public void update(Observable<StockEvent> sender, StockEvent event);
}
