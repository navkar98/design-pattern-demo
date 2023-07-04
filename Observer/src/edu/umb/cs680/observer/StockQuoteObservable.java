package edu.umb.cs680.observer;

import java.util.LinkedList;
import java.util.List;

public class StockQuoteObservable extends Observable<edu.umb.cs680.observer.StockEvent> {
	private LinkedList<Observer<StockEvent>> observers = new LinkedList<>();

	public void clearObservers() {
		observers.clear();
		
	}
	public List<Observer<StockEvent>> getObservers(){
		return observers;
	}
	
	public int countObservers() {
		return observers.size();
		
	}

	public void changeQuote(String t, double q){
		notifyObservers( new StockEvent(t, q));
	}
}
