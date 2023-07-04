package edu.umb.cs680.proxy;

import edu.umb.cs680.proxy.Directory;
import edu.umb.cs680.proxy.File;
import edu.umb.cs680.proxy.FileSystem;
import edu.umb.cs680.proxy.Link;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkTest {
    private static FileSystem fs;

    @BeforeAll
    public static void setUpFS(){
        fs = edu.umb.cs680.proxy.TestFixtureInitializer.createFS();
    }

    private String[] linkToStringArray(Link d){
        String[] linkInfo = { d.getName(), d.getParent().getName(), d.getTarget().getName()};
        return linkInfo;
    }

    @Test
    public void isDirectoryCheck() {
        boolean expected = false;

        Directory root = fs.getRootDirs().getFirst();
        Link d = (Link) root.getChildren().get(3);

        assertEquals(expected, d.isDirectory());
    }

    @Test
    public void linkTargetCheck() {
        String[] expectedTarget = {"d", "root", "pictures"};

        Directory root = fs.getRootDirs().getFirst();
        Link d = (Link) root.getChildren().get(3);

        assertArrayEquals(expectedTarget, linkToStringArray(d));
    }
}
