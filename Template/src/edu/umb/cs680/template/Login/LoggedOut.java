package edu.umb.cs680.template.Login;

public class LoggedOut implements State{
    private static LoggedOut inst = null;

    private LoggedOut(){};

    public static LoggedOut getInstance(){
        if (inst == null)
            inst = new LoggedOut();
        return inst;
    }

    @Override
    public void login(EncryptedString pwd, SecurityContext ctx) {
        System.out.println("In LoggedOut login");
        if ( Authenticator.authenticate(ctx, pwd) ) {
            ctx.changeState(ctx.logInInst);
        }
    }

    @Override
    public void logout(SecurityContext ctx) {
        System.out.println("In loggedOut logout");
    }

    @Override
    public String getState(SecurityContext ctx) {
        return "Logged out";
    }
}
