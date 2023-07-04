package edu.umb.cs680.observer;

import java.util.ArrayList;
import java.util.List;

public class DataWarehouse {
    // This class keeps track of all updates made till date.
    private static List<StockEvent> lineChartDataHistory = new ArrayList<>();
    private static List<StockEvent> tableDataHistory = new ArrayList<>();

    public static void updateLineChartDataHistory(StockEvent stockEvent){
        lineChartDataHistory.add(stockEvent);
    }

    public static void updateTableDataHistory(StockEvent stockEvent){
        tableDataHistory.add(stockEvent);
    }

    public static List<StockEvent> getLineChartDataHistory() {
        return lineChartDataHistory;
    }

    public static List<StockEvent> getTableDataHistory() {
        return tableDataHistory;
    }

    public static void setLineChartDataHistory(List<StockEvent> lineChartDataHistory) {
        DataWarehouse.lineChartDataHistory = lineChartDataHistory;
    }

    public static void setTableDataHistory(List<StockEvent> tableDataHistory) {
        DataWarehouse.tableDataHistory = tableDataHistory;
    }
}
