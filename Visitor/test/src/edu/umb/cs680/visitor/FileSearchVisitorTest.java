package edu.umb.cs680.visitor;

import edu.umb.cs680.visitor.fs.Directory;
import edu.umb.cs680.visitor.fs.File;
import edu.umb.cs680.visitor.fs.FileSystem;
import edu.umb.cs680.visitor.fs.util.FileSearchVisitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileSearchVisitorTest {
    private static FileSystem fs;

    @BeforeAll
    public static void setUpFS(){
        fs = edu.umb.cs680.visitor.TestFixtureInitializer.createFS();
    }

    private String[] fileToStringArray(File d){
        String[] fileInfo = { d.getName(), String.valueOf(d.getSize()), d.getParent().getName()};
        return fileInfo;
    }

    @Test
    public void searchFile() {
        String[] expectedFile = {"b", "5055", "pictures"};

        Directory root = fs.getRootDirs().getFirst();
        FileSearchVisitor visitor = new FileSearchVisitor("b");
        root.accept(visitor);

        assertArrayEquals(expectedFile, fileToStringArray(visitor.getFoundFiles().get(0)));
    }

}
