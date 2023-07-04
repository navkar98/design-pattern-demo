package edu.umb.cs680.state;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.LinkedList;

import static jdk.nashorn.internal.objects.Global.println;

public class SecurityContext {
    State ctxState = null;
    protected LinkedList<LocalDateTime> loginTimeStamps = new LinkedList<LocalDateTime>();
    State logOutInst = LoggedOut.getInstance();
    State logInInst = LoggedIn.getInstance();

    public SecurityContext(User usr){
        this.changeState(logOutInst);
    }

    public void changeState(State newState){
        this.ctxState = newState;
        System.out.println(this.ctxState);
    }

    public boolean isActive(){
        // Checks if user last login time is less than 5 secs then user is active.
        return this.loginTimeStamps.getLast().until(LocalDateTime.now(), ChronoUnit.SECONDS) < 5;
    }

    public void login(EncryptedString pwd){
        // Adding time at which user is logged in
        this.loginTimeStamps.push(LocalDateTime.now());

        this.ctxState.login(pwd, this);
    }

    public void logout(){
        this.ctxState.logout(this);
    }

    public String getCtxState(){
        return this.ctxState.getState(this);
    }

    public State getState(){
        System.out.println(this.ctxState);
        return this.ctxState;
    }

    public static void main(String[] args) {
        SecurityContext ctx = new SecurityContext(new User());
        SecurityContext ctx1 = new SecurityContext(new User());
        System.out.println(ctx.getCtxState());
        System.out.println(ctx.getState());

        ctx.login(new EncryptedString());
        System.out.println(ctx.getCtxState());
        System.out.println(ctx.getState());
        System.out.println(ctx.getState().equals(ctx1.getState()));

        ctx.login(new EncryptedString());
        System.out.println(ctx.getCtxState());
        System.out.println(ctx.getState());

        ctx.logout();
        System.out.println(ctx.getCtxState());
        System.out.println(ctx.getState());

        ctx.logout();
        System.out.println(ctx.getCtxState());
        System.out.println(ctx.getState());
    }
}
