package edu.umb.cs680.composite;

import edu.umb.cs680.composite.Directory;
import edu.umb.cs680.composite.File;
import edu.umb.cs680.composite.FileSystem;

import java.time.LocalDateTime;

public class TestFixtureInitializer {
    public static FileSystem createFS(){
        FileSystem fs = FileSystem.getFileSystem();

        Directory root = new Directory(null, "root", 0, LocalDateTime.now());

        // Apps Directory
        Directory apps = new Directory(root, "apps", 0, LocalDateTime.now());
        File x = new File(apps, "x", 10, LocalDateTime.now());
        apps.appendChild(x);
        File y = new File(apps, "y", 50, LocalDateTime.now());
        apps.appendChild(y);
        root.appendChild(apps);

        // Lib Directory
        Directory lib = new Directory(root, "lib", 0, LocalDateTime.now());
        File z = new File(lib, "z", 700, LocalDateTime.now());
        lib.appendChild(z);
        root.appendChild(lib);

        // Home Directory
        Directory home = new Directory(root, "home", 0, LocalDateTime.now());
        File d = new File(home, "d", 1024, LocalDateTime.now());
        home.appendChild(d);
        root.appendChild(home);

        // Home -> Code Directory
        Directory code = new Directory(home, "code", 0, LocalDateTime.now());
        File a = new File(code, "a", 200, LocalDateTime.now());
        code.appendChild(a);
        File b = new File(code, "b", 5055, LocalDateTime.now());
        code.appendChild(b);
        File c = new File(code, "c", 4096, LocalDateTime.now());
        code.appendChild(c);
        home.appendChild(code);

        if (fs.getRootDirs().size() <= 0){
            fs.appendRootDir(root);
        }

        return fs;
    }
}
