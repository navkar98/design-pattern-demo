package edu.umb.cs680.template;

import edu.umb.cs680.template.PrintingFramework.PrintJob;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.template.ModelABC.*;
import edu.umb.cs680.template.ModelXYZ.*;
import edu.umb.cs680.template.Login.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class PrintJobExecutorTest {
    @Test
    public void checkPrintJobModelXYZ() throws Exception {
        edu.umb.cs680.template.ModelXYZ.PrintJobExecutor ex = new edu.umb.cs680.template.ModelXYZ.PrintJobExecutor();

        PrintJob pj = new PrintJob(1, "My First Print Job");

        ex.execute(pj, new EncryptedString(), new SecurityContext(new User()));
    }

    @Test
    public void checkPrintJobModelABC() throws Exception {
        edu.umb.cs680.template.ModelABC.PrintJobExecutor ex = new edu.umb.cs680.template.ModelABC.PrintJobExecutor();

        PrintJob pj = new PrintJob(2, "My Second Print Job");

        ex.execute(pj, new EncryptedString(), new SecurityContext(new User()));
    }

    @Ignore
    public void checkPrintJobWithoutLoginModelABC() {
        SecurityContext ctx = new SecurityContext(new User());
        SecurityContext ctx1 = new SecurityContext(new User());

        ctx1.login(new EncryptedString());
        assertEquals(ctx.getState(), ctx1.getState());
    }
}
