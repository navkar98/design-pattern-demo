package edu.umb.cs680.visitor.fs;

import edu.umb.cs680.visitor.fs.util.FSVisitor;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement {
    private final LinkedList<FSElement> childrens = new LinkedList<>();

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime){
        super(parent, name, size, creationTime);
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public void accept(FSVisitor v) {
        v.visit(this);
        for(FSElement e: this.childrens){
            e.accept(v);
        }
    }

    public LinkedList<FSElement> getChildren(){
        return this.childrens;
    }

    public void appendChild(FSElement child){
        this.childrens.add(child);
    }

    public int countChildren(){
        return this.childrens.size();
    }

    public LinkedList<Directory> getSubDirectories(){
        LinkedList<Directory> subDirectories = new LinkedList<>();
        for (FSElement el: this.childrens) {
            if (el.isDirectory()){
                subDirectories.add((Directory) el);
            }
        }

        return subDirectories;
    }

    public LinkedList<File> getFiles(){
        LinkedList<File> files = new LinkedList<>();
        for (FSElement el: this.childrens) {
            if (!el.isDirectory()){
                files.add((File) el);
            }
        }

        return files;
    }

    public int getTotalSize(){
        int totalSize = 0;

        for (FSElement el: this.childrens){
            if (el.isDirectory()) {
                Directory dirEl = (Directory) el;
                totalSize += dirEl.getTotalSize();
            }else {
                if (el instanceof File){
                    File fileEl = (File) el;
                    totalSize += fileEl.getSize();
                }
            }
        }

        return totalSize;
    }
}
