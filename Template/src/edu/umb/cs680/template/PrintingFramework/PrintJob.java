package edu.umb.cs680.template.PrintingFramework;

public class PrintJob {
    private final int id;
    private final String name;

    public PrintJob(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
