package edu.umb.cs680.proxyyy;

import java.time.LocalDateTime;

public abstract class FSElement {
    protected String name;
    protected int size;
    protected LocalDateTime creationTime;
    public Directory parent;

    public FSElement(Directory parent, String name, int size, LocalDateTime creationTime){
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
        this.parent = parent;
    }

    public Directory getParent(){
        return this.parent;
    }

    public int getSize(){
        return this.size;
    }

    public LocalDateTime getCreationTime(){
        return this.creationTime;
    }

    public String getName(){
        return this.name;
    }

    public abstract boolean isDirectory();
}
