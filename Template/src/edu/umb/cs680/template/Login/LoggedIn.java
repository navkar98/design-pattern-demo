package edu.umb.cs680.template.Login;

public class LoggedIn implements State {
    private static LoggedIn inst = null;

    private LoggedIn(){};

    public static LoggedIn getInstance(){
        if (inst == null)
            inst = new LoggedIn();
        return inst;
    }

    @Override
    public void login(EncryptedString pwd, SecurityContext ctx) {
        System.out.println("In LoggedIn login");
        if ( !ctx.isActive() ){
            ctx.changeState(ctx.logOutInst);
            ctx.login(pwd);
        }
    }

    @Override
    public void logout(SecurityContext ctx) {
        System.out.println("In LoggedIn logout");
        ctx.changeState(ctx.logOutInst);
    }

    @Override
    public String getState(SecurityContext ctx) {
        return "Logged in";
    }
}
