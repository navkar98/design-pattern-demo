package edu.umb.cs680.state;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class SecurityContextTest {
    @Test
    public void checkLoggedOutState(){
        SecurityContext ctx = new SecurityContext(new User());
        assertTrue(ctx.getState() instanceof LoggedOut);
    }

    @Test
    public void checkLoggedInState(){
        SecurityContext ctx2 = new SecurityContext(new User());

        ctx2.login(new EncryptedString());
        assertTrue(ctx2.getState() instanceof LoggedIn);
    }

    @Test
    public void equalityCheckLoggedInAndLoggedOut(){
        SecurityContext ctx = new SecurityContext(new User());
        SecurityContext ctx1 = new SecurityContext(new User());

        ctx1.login(new EncryptedString());
        assertEquals(ctx.getClass(), ctx1.getClass());
    }

    @Test
    public void inactiveLoginCheck(){
        SecurityContext ctx = new SecurityContext(new User());

        ctx.login(new EncryptedString());

        try {
            // Waits for user to get out of active time limit.
            TimeUnit.SECONDS.sleep(10);
            System.out.println(ctx.loginTimeStamps.getLast().until(LocalDateTime.now(), ChronoUnit.SECONDS));

            assertFalse(ctx.isActive());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
