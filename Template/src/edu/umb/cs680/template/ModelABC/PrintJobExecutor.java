package edu.umb.cs680.template.ModelABC;

import edu.umb.cs680.template.Login.EncryptedString;
import edu.umb.cs680.template.Login.LoggedIn;
import edu.umb.cs680.template.Login.SecurityContext;
import edu.umb.cs680.template.Login.User;
import edu.umb.cs680.template.PrintingFramework.PrintJob;

public class PrintJobExecutor extends edu.umb.cs680.template.PrintingFramework.PrintJobExecutor {
    public PrintJobExecutor(){}
    @Override
    protected void doAuthentication(EncryptedString pwd, SecurityContext ctx) {
        try{
            ctx.login(pwd);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    protected void doAccessControl() {
        // Does nothing
    }

    @Override
    protected void doPrint(PrintJob job, SecurityContext ctx) {
        // Prints out the job name after checking if user is logged active
        if (ctx.getState() instanceof LoggedIn && ctx.isActive()){
            System.out.println(job.getName());
        }
    }

    @Override
    protected void doErrorHandling() {

    }

    public static void main(String[] args) {}
}
