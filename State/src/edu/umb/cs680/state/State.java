package edu.umb.cs680.state;

public interface State {
    void login(EncryptedString pwd, SecurityContext ctx);
    void logout(SecurityContext ctx);

    String getState(SecurityContext ctx);
}
