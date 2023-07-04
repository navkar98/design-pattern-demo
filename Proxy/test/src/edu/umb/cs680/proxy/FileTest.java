package edu.umb.cs680.proxy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileTest {
    private static FileSystem fs;

    @BeforeAll
    public static void setUpFS(){
        fs = edu.umb.cs680.proxy.TestFixtureInitializer.createFS();
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
        String[] expectedDir = {"y", "50", "bin"};

        Directory root = fs.getRootDirs().getFirst();
        Directory lib = root.getSubDirectories().get(1);

        assertArrayEquals(expectedDir, fileToStringArray(lib.getFiles().get(0)));
    }

}
