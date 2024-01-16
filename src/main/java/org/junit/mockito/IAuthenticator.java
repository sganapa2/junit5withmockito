package org.junit.mockito;

import org.junit.mockito.customexceptions.EmptyCredentialsException;
import org.junit.mockito.customexceptions.NotAuthenticatedException;

public interface IAuthenticator {
        /**
         * User authentication method definition.
         *
         * @param username The user name to authenticate.
         * @param password The password to authenticate the user.
         * @return True if the user has been authenticated; false if it has not.
         */
        public boolean authenticateUser(String username, String password);

        public boolean authenticateUser2(String username, String password) throws EmptyCredentialsException;

        /**
         * Tries to authenticate an user with the received user name and password, with the ←-
         received
         * AuthenticatorInterface interface implementation in the constructor.
         *
         * @param username The user name to authenticate.
         * @param password The password to authenticate the user.
         * @throws NotAuthenticatedException If the user can’t be authenticated.
         */
        public void authenticateUser3(String username, String password) throws NotAuthenticatedException;

}
