package org.junit.mockito;

import java.util.Locale;

public class CustomStringUtils {

    public String convertToUppercase(String input) {
        return input.toUpperCase(Locale.ROOT);
    }
    public String convertToLowercase(String input) {
        return input.toLowerCase(Locale.ROOT);
    }

}
