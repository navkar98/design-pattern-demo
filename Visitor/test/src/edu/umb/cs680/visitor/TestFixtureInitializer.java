package edu.umb.cs680.visitor;

import java.time.LocalDateTime;
import edu.umb.cs680.visitor.fs.*;

public class TestFixtureInitializer {
    public static FileSystem createFS(){
        FileSystem fs = FileSystem.getFileSystem();

        Directory root = new Directory(null, "root", 0, LocalDateTime.now());

        // Apps Directory
        Directory apps = new Directory(root, "apps", 0, LocalDateTime.now());
        File x = new File(apps, "x", 10, LocalDateTime.now());
        apps.appendChild(x);
        root.appendChild(apps);

        // bin Directory
        Directory bin = new Directory(root, "bin", 0, LocalDateTime.now());
        File y = new File(bin, "y", 50, LocalDateTime.now());
        bin.appendChild(y);
        root.appendChild(bin);

        // Home Directory
        Directory home = new Directory(root, "home", 0, LocalDateTime.now());
        File c = new File(home, "c", 1024, LocalDateTime.now());
        home.appendChild(c);
        root.appendChild(home);

        // Home -> pictures Directory
        Directory pictures = new Directory(home, "pictures", 0, LocalDateTime.now());
        File a = new File(pictures, "a", 200, LocalDateTime.now());
        pictures.appendChild(a);
        File b = new File(pictures, "b", 5055, LocalDateTime.now());
        pictures.appendChild(b);
        home.appendChild(pictures);

        // Links
        Link d = new Link(root, "d", 0, LocalDateTime.now(), pictures);
        Link e = new Link(root, "e", 0, LocalDateTime.now(), x);
        root.appendChild(d);
        root.appendChild(e);

        if (fs.getRootDirs().size() <= 0){
            fs.appendRootDir(root);
        }

        return fs;
    }
}
