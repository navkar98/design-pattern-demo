package edu.umb.cs680.visitor.fs.util;

import edu.umb.cs680.visitor.fs.*;

public interface FSVisitor {
    void visit(Link link);
    void visit(Directory dir);
    void visit(File file);
}
