package org.junit.mockito.customexceptions;

public class EmptyCredentialsException extends Exception {
    public EmptyCredentialsException() {
        super("Empty credentials!");
    }
}