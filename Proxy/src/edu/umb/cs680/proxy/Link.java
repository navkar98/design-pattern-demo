package edu.umb.cs680.proxyy;

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

    public FSElement getTarget(){
        return this.target;
    }
}
