package edu.umb.cs680.template.PrintingFramework;

import edu.umb.cs680.template.Login.*;

public abstract class PrintJobExecutor {
    // Template method
    public void execute(PrintJob job, EncryptedString pwd, SecurityContext ctx) throws Exception {
        doAuthentication(pwd, ctx);
        doAccessControl();
        doPrint(job, ctx);
        doErrorHandling();
    }

    protected abstract void doAuthentication(EncryptedString pwd, SecurityContext ctx);

    protected abstract void doAccessControl();

    protected abstract void doPrint(PrintJob job, SecurityContext ctx);

    protected abstract void doErrorHandling();
}
