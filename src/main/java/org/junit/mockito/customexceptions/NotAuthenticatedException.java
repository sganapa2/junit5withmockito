package org.junit.mockito.customexceptions;

public class NotAuthenticatedException extends Exception {
    public NotAuthenticatedException() {
        super("Could not authenticate!");
    }
}
