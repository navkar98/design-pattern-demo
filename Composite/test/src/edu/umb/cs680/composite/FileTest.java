package edu.umb.cs680.composite;

import edu.umb.cs680.composite.Directory;
import edu.umb.cs680.composite.File;
import edu.umb.cs680.composite.FileSystem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileTest {
    private static FileSystem fs;

    @BeforeAll
    public static void setUpFS(){
        fs = edu.umb.cs680.composite.TestFixtureInitializer.createFS();
    }

    private String[] fileToStringArray(File d){
        String[] fileInfo = { d.getName(), String.valueOf(d.getSize()), d.getParent().getName()};
        return fileInfo;
    }

    @Test
    public void isDirectoryCheck() {
        boolean expected = false;

        Directory root = fs.getRootDirs().getFirst();
        Directory lib = root.getSubDirectories().get(1);

        assertEquals(expected, lib.getFiles().get(0).isDirectory());
    }

    @Test
    public void dirEqualityCheck() {
        String[] expectedDir = {"z", "700", "lib"};

        Directory root = fs.getRootDirs().getFirst();
        Directory lib = root.getSubDirectories().get(1);

        assertArrayEquals(expectedDir, fileToStringArray(lib.getFiles().get(0)));
    }

}
