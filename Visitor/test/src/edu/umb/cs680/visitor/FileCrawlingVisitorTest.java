package edu.umb.cs680.visitor;

import edu.umb.cs680.visitor.fs.util.CountingVisitor;
import edu.umb.cs680.visitor.fs.util.FileCrawlingVisitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.umb.cs680.visitor.fs.*;

public class FileCrawlingVisitorTest {
    private static FileSystem fs;

    @BeforeAll
    public static void setUpFS() {
        fs = edu.umb.cs680.visitor.TestFixtureInitializer.createFS();
    }

    @Test
    public void checkCrawlingStatus() {
        boolean expected = true;

        Directory root = fs.getRootDirs().getFirst();
        FileCrawlingVisitor visitor = new FileCrawlingVisitor("b");
        root.accept(visitor);

        assertEquals(expected, visitor.hasCrawled());
    }

    @Test
    public void checkFalseCrawlingStatus() {
        boolean expected = false;

        Directory root = fs.getRootDirs().getFirst();
        FileCrawlingVisitor visitor = new FileCrawlingVisitor("z");
        root.accept(visitor);

        assertEquals(expected, visitor.hasCrawled());
    }
}
