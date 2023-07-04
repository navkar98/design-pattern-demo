package edu.umb.cs680.visitor.fs.util;

import edu.umb.cs680.visitor.fs.Directory;
import edu.umb.cs680.visitor.fs.File;
import edu.umb.cs680.visitor.fs.Link;

public class CountingVisitor implements FSVisitor{
    private int count = 0;

    public CountingVisitor(){}


    @Override
    public void visit(Link link) {
        this.count++;
    }

    @Override
    public void visit(Directory dir) {
        this.count++;
    }

    @Override
    public void visit(File file) {
        this.count++;
    }

    public int getCount(){
        return this.count;
    }
}
