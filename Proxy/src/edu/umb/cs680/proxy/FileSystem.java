package edu.umb.cs680.proxyyyy;

import java.util.LinkedList;

public class FileSystem {
    private final LinkedList<Directory> rootDirs = new LinkedList<>();

    private static FileSystem inst = null;

    private FileSystem(){}

    public static FileSystem getFileSystem(){
        if (inst == null){
            inst = new FileSystem();
        }
        return inst;
    }

    public LinkedList<Directory> getRootDirs(){
        return this.rootDirs;
    }

    public void appendRootDir(Directory root){
        this.rootDirs.add(root);
    }
}
