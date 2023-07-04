package edu.umb.cs680.observer;

import edu.umb.cs680.observer.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.DataFormatException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StockQuoteObserverableTest {

    private ArrayList<String[]> stockListToStringArray(List<StockEvent> elList) {
        ArrayList<String[]> elInfoList = new ArrayList<>();

        for (StockEvent d : elList) {
            String[] stockIno = {d.getTicker(), String.valueOf(d.getQuote())};

            elInfoList.add(stockIno);
        }
        return elInfoList;
    }

    @Test
    public void updateLineChartWithoutLE(){
        DataWarehouse.setLineChartDataHistory(new ArrayList<>());

        List<String []> expected = Arrays.asList(
                new String[] {"GOOG", "500.0"},
                new String[]{"APPL", "2250.0"},
                new String[]{"MICR", "700.0"});

        StockQuoteObservable observable = new StockQuoteObservable();
        Observer<StockEvent> quoteUpdateLineChart = new LineChartObserver();

        observable.addObserver( quoteUpdateLineChart );
        observable.changeQuote("GOOG", 500);
        observable.changeQuote("APPL", 2250);
        observable.changeQuote("MICR", 700);

        observable.removeObserver(quoteUpdateLineChart);
        assertArrayEquals(expected.toArray(), stockListToStringArray(DataWarehouse.getLineChartDataHistory()).toArray());
    }

    @Test
    public void updateLineChartWithLE(){
        DataWarehouse.setLineChartDataHistory(new ArrayList<>());

        List<String []> expected = Arrays.asList(
                new String[]{"META", "8000.0"},
                new String[]{"CHAS", "693.0"});

        StockQuoteObservable observable = new StockQuoteObservable();
        Observer<StockEvent> quoteUpdateLineChart = (Observable<StockEvent> sender, StockEvent stockEvent) -> {
            DataWarehouse.updateLineChartDataHistory(stockEvent);
            System.out.println("Line chart for ticker " + stockEvent.getTicker() + " updated to " + stockEvent.getQuote());
        };

        observable.addObserver( quoteUpdateLineChart );
        observable.changeQuote("META", 8000);
        observable.changeQuote("CHAS", 693);
        observable.removeObserver(quoteUpdateLineChart);

        assertArrayEquals(expected.toArray(), stockListToStringArray(DataWarehouse.getLineChartDataHistory()).toArray());
    }

    @Test
    public void updateTableWithoutLE(){
        DataWarehouse.setTableDataHistory(new ArrayList<>());

        List<String []> expected = Arrays.asList(
                new String[] {"GOOG", "500.0"},
                new String[]{"APPL", "2250.0"},
                new String[]{"MICR", "700.0"});

        StockQuoteObservable observable = new StockQuoteObservable();
        Observer<StockEvent> quoteUpdateTable = new TableObserver();

        observable.addObserver( quoteUpdateTable );
        observable.changeQuote("GOOG", 500);
        observable.changeQuote("APPL", 2250);
        observable.changeQuote("MICR", 700);

        observable.removeObserver(quoteUpdateTable);
        assertArrayEquals(expected.toArray(), stockListToStringArray(DataWarehouse.getTableDataHistory()).toArray());
    }

    @Test
    public void updateTableWithLE(){
        DataWarehouse.setTableDataHistory(new ArrayList<>());

        List<String []> expected = Arrays.asList(
                new String[]{"META", "8000.0"},
                new String[]{"CHAS", "693.0"});

        StockQuoteObservable observable = new StockQuoteObservable();
        Observer<StockEvent> quoteUpdateTable = (Observable<StockEvent> sender, StockEvent stockEvent) -> {
            DataWarehouse.updateTableDataHistory(stockEvent);
            System.out.println("Table for ticker " + stockEvent.getTicker() + " updated to " + stockEvent.getQuote());
        };

        observable.addObserver( quoteUpdateTable );
        observable.changeQuote("META", 8000);
        observable.changeQuote("CHAS", 693);
        observable.removeObserver(quoteUpdateTable);

        assertArrayEquals(expected.toArray(), stockListToStringArray(DataWarehouse.getTableDataHistory()).toArray());
    }
}
