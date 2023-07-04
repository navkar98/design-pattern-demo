package edu.umb.cs680.template.ModelXYZ;

import edu.umb.cs680.template.Login.EncryptedString;
import edu.umb.cs680.template.Login.SecurityContext;
import edu.umb.cs680.template.PrintingFramework.PrintJob;

public class PrintJobExecutor extends edu.umb.cs680.template.PrintingFramework.PrintJobExecutor {
    public PrintJobExecutor(){}


    @Override
    protected void doAuthentication(EncryptedString pwd, SecurityContext ctx) {
        // Does no auth
    }

    @Override
    protected void doAccessControl() {
        // Does nothing
    }

    @Override
    protected void doPrint(PrintJob job, SecurityContext ctx) {
        System.out.println(job.getName());
    }

    @Override
    protected void doErrorHandling() {

    }

    public static void main(String[] args) {}
}

