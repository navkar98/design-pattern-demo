package edu.umb.cs680.proxy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileSystemTest {
    private static FileSystem fs;

    @BeforeAll
    public static void setUpFS() {
        fs = edu.umb.cs680.proxy.TestFixtureInitializer.createFS();
    }

    private String[] dirToStringArray(Directory d){
        String parentName = d.getParent() == null ? null : d.getParent().getName();

        String[] dirInfo = { d.getName(), String.valueOf(d.getSize()), parentName};
        return dirInfo;
    }

    @Test
    public void checkDirsList() {
        String[] expectedDir = {"root", "0", null};

        assertArrayEquals(expectedDir, dirToStringArray(fs.getRootDirs().getFirst()));
    }

    @Test
    public void appendNewRootDirectory() {
        Directory rootD = new Directory(null, "rootD", 0, LocalDateTime.now());
        fs.appendRootDir(rootD);

        int expectedLength = 2;

        assertEquals(expectedLength, fs.getRootDirs().size());
    }
}
