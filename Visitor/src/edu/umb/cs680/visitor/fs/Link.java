package edu.umb.cs680.visitor.fs;

import edu.umb.cs680.visitor.fs.util.FSVisitor;

import java.time.LocalDateTime;

public class Link extends FSElement{
    private final FSElement target;

    public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
        super(parent, name, size, creationTime);
        this.target = target;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public void accept(FSVisitor v) {
        v.visit(this);
    }

    public FSElement getTarget(){
        return this.target;
    }
}
