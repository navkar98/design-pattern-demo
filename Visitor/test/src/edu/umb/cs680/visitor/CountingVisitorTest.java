package edu.umb.cs680.visitor;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.umb.cs680.visitor.fs.*;
import edu.umb.cs680.visitor.fs.util.*;

public class CountingVisitorTest {

    private static FileSystem fs;

    @BeforeAll
    public static void setUpFS(){
        fs = edu.umb.cs680.visitor.TestFixtureInitializer.createFS();
    }

    @Test
    public void countAllElements() {
        int expected = 12;

        Directory root = fs.getRootDirs().getFirst();
        CountingVisitor visitor = new CountingVisitor();
        root.accept(visitor);

        assertEquals(expected, visitor.getCount());
    }
}
