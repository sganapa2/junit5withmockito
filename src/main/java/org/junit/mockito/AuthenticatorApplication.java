package org.junit.mockito;

import org.junit.mockito.customexceptions.EmptyCredentialsException;
import org.junit.mockito.customexceptions.NotAuthenticatedException;

public class AuthenticatorApplication {

    private final IAuthenticator authenticator;
    /**
     * AuthenticatorApplication constructor.
     *
     * @param authenticator Authenticator interface implementation.
     */
    public AuthenticatorApplication(IAuthenticator authenticator) {
        this.authenticator = authenticator;
    }
    /**
     * Tries to authenticate an user with the received user name and password, with the ←-
     received
     * IAuthenticator interface implementation in the constructor.
     *
     * @param username The user name to authenticate.
     * @param password The password to authenticate the user.
     * @return True if the user has been authenticated; false if it has not.
     */
    public boolean authenticate(String username, String password) {
        boolean authenticated;
        authenticated = this.authenticator.authenticateUser(username, password);
        return authenticated;
    }

    public boolean authenticate2(String username, String password) throws EmptyCredentialsException {
        boolean authenticated;
        authenticated = this.authenticator.authenticateUser2(username, password);
        return authenticated;
    }

    public void authenticate3(String username, String password) throws NotAuthenticatedException {
        this.authenticator.authenticateUser3(username, password);
    }
}
