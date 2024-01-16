package org.junit.mockito;

public class PrivateMethodTestingClass {

    private String privateMethod(String input) {
        return "Processed out from private method for input " + input;
    }

    public String privateMathodCaller(String input) {
        return privateMethod(input);
    }
}
