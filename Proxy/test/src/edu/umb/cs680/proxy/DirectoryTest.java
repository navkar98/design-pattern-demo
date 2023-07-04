package edu.umb.cs680.proxy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectoryTest {

    private static FileSystem fs;

    @BeforeAll
    public static void setUpFS(){
        fs = edu.umb.cs680.proxy.TestFixtureInitializer.createFS();
    }

    private String[] dirToStringArray(Directory d){
        String parentName = d.getParent() == null ? null : d.getParent().getName();

        String[] dirInfo = { d.getName(), String.valueOf(d.getSize()), parentName};
        return dirInfo;
    }

    @Test
    public void dirEqualityCheck() {
        String[] expectedDir = {"root", "0", null};

        assertArrayEquals(expectedDir, dirToStringArray(fs.getRootDirs().getFirst()));
    }

    @Test
    public void isDirectoryCheck() {
        boolean expected = true;

        Directory root = fs.getRootDirs().getFirst();

        assertEquals(expected, root.isDirectory());
    }

    @Test
    public void getRootDirChildrenCheck() {
        int expected = 5;

        Directory root = fs.getRootDirs().getFirst();

        assertEquals(expected, root.getChildren().size());
    }

    @Test
    public void countLibDirChildrenCheck() {
        int expected = 1;

        Directory root = fs.getRootDirs().getFirst();
        Directory lib = root.getSubDirectories().get(1);

        assertEquals(expected, lib.countChildren());
    }

    @Test
    public void rootDirTotalSizeCheck() {
        int expected = 6339;

        Directory root = fs.getRootDirs().getFirst();
        System.out.println(root.getTotalSize());

        assertEquals(expected, root.getTotalSize());
    }
}
