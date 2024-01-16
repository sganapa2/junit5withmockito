package junitmockito;

import org.junit.jupiter.api.Test;
import org.junit.mockito.AuthenticatorApplication;
import org.junit.mockito.IAuthenticator;
import org.junit.mockito.customexceptions.EmptyCredentialsException;
import org.junit.mockito.customexceptions.NotAuthenticatedException;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class AuthenticatorApplicationTest {

    @Test
    public void testAuthenticate() {
        IAuthenticator authenticatorMock = Mockito.mock(IAuthenticator.class);
        String username = "TestUser";
        String password = "TestPass";
        AuthenticatorApplication authenticator = new AuthenticatorApplication(authenticatorMock);
        when(authenticatorMock.authenticateUser(username, password))
                .thenReturn(false);
        boolean actual = authenticator.authenticate(username, password);
        assertFalse(actual);
        verify(authenticatorMock).authenticateUser(username, password); //Verify that method has been called

        //verify(authenticatorMock).authenticateUser(username, "not the original password");
        //The test will fail.
    }

    @Test
    public void verifyBehaviourTest() {
        IAuthenticator authenticatorMock = Mockito.mock(IAuthenticator.class);
        String username = "TestUser";
        String password = "TestPass";
        AuthenticatorApplication authenticator = new AuthenticatorApplication(authenticatorMock);
        boolean actual = authenticator.authenticate(username, password);
        verify(authenticatorMock, times(1)).authenticateUser(username, password);
        verify(authenticatorMock, atLeastOnce()).authenticateUser(username, password);
        verify(authenticatorMock, atLeast(1)).authenticateUser(username, password);
        verify(authenticatorMock, atMost(1)).authenticateUser(username, password);

    }

    @Test
    public void testAuthenticateEmptyCredentialsException() throws EmptyCredentialsException {
        IAuthenticator authenticatorMock;
        AuthenticatorApplication authenticator;
        authenticatorMock = Mockito.mock(IAuthenticator.class);
        authenticator = new AuthenticatorApplication(authenticatorMock);
        when(authenticatorMock.authenticateUser2("", ""))
                .thenThrow(new EmptyCredentialsException());
        assertThrows(EmptyCredentialsException.class, () -> authenticator.authenticate2("", ""));
    }

    @Test
    public void testAuthenticateEmptyCredentialsExceptionWithVoid()
            throws NotAuthenticatedException, EmptyCredentialsException {
        IAuthenticator authenticatorMock;
        AuthenticatorApplication authenticator;
        authenticatorMock = Mockito.mock(IAuthenticator.class);
        authenticator = new AuthenticatorApplication(authenticatorMock);

        when(authenticatorMock.authenticateUser2("", ""))
                .thenThrow(new EmptyCredentialsException());
        assertThrows(EmptyCredentialsException.class, () -> authenticator.authenticate2("", ""));

        doThrow(new NotAuthenticatedException())
                .when(authenticatorMock)
                        .authenticateUser3("", "");
        assertThrows(NotAuthenticatedException.class, () -> authenticator.authenticate3("", ""));
    }

}
