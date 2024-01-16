package junitmockito;

import org.junit.mockito.IAuthenticator;
import org.junit.mockito.customexceptions.EmptyCredentialsException;
import org.junit.mockito.customexceptions.NotAuthenticatedException;

public class FakeAuthenticatorService implements IAuthenticator {
    @Override
    public boolean authenticateUser(String username, String password) {
        return false;
    }

    @Override
    public boolean authenticateUser2(String username, String password) throws EmptyCredentialsException {
        return false;
    }

    @Override
    public void authenticateUser3(String username, String password) throws NotAuthenticatedException {
        // do some logic as per test expectation
    }
}
