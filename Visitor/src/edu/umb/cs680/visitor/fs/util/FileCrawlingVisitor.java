package edu.umb.cs680.visitor.fs.util;

import edu.umb.cs680.visitor.fs.Directory;
import edu.umb.cs680.visitor.fs.File;
import edu.umb.cs680.visitor.fs.Link;

import java.util.LinkedList;

public class FileCrawlingVisitor implements FSVisitor{
    private final String fileName;
    private boolean hasCrawled;

    public FileCrawlingVisitor(String fileName){
        this.fileName = fileName;
        this.hasCrawled = false;
    }
    @Override
    public void visit(Link link) {
        return;
    }

    @Override
    public void visit(Directory dir) {
        return;
    }

    @Override
    public void visit(File file) {
        if(file.getName().equals(this.fileName)){
            hasCrawled = true;
            System.out.println(this.fileName + " is being crawled");
        }
    }

    public boolean hasCrawled(){
        return this.hasCrawled;
    }
}
