package edu.umb.cs680.composite;

import edu.umb.cs680.composite.Directory;
import edu.umb.cs680.composite.FileSystem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectoryTest {

    private static FileSystem fs;

    @BeforeAll
    public static void setUpFS(){
        fs = edu.umb.cs680.composite.TestFixtureInitializer.createFS();
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
    public void getRootDirChildrenSizeCheck() {
        int expected = 3;

        Directory root = fs.getRootDirs().getFirst();

        assertEquals(expected, root.getChildren().size());
    }

    @Test
    public void getRootDirChildrenCheck() {
        int expected = 3;

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
        int expected = 11135;

        Directory root = fs.getRootDirs().getFirst();

        assertEquals(expected, root.getTotalSize());
    }
}
