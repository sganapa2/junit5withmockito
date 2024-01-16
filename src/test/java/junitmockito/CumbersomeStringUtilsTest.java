package junitmockito;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.mockito.CustomStringUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CumbersomeStringUtilsTest {
    CustomStringUtils classUnderTest;

    @Test
    void testUppercaseConversion() {
        assertEquals("CAT", classUnderTest.convertToUppercase("cat"));
        assertEquals("DOG", classUnderTest.convertToUppercase("Dog"));
        assertEquals("DESSERTS", classUnderTest.convertToUppercase("DESSeRTS"));
        assertEquals("121", classUnderTest.convertToUppercase("121"));
        assertEquals("UPPERCASE-VALUE", classUnderTest.convertToUppercase("UPPERCASE-VALUE"));
    }

    @Test
    void testLowercaseConversion() {
        assertEquals("helloworld", classUnderTest.convertToLowercase("HelloWorld"));
        assertEquals("junit5", classUnderTest.convertToLowercase("JUnit5"));
        assertEquals("parameterizedtests", classUnderTest.convertToLowercase("PARAMETERIZEDTESTS"));
        assertEquals("121", classUnderTest.convertToLowercase("121"));
        assertEquals("lowercase-value", classUnderTest.convertToLowercase("lowercase-value"));
    }

    // ... many more test methods for different scenarios

    @ParameterizedTest
    @CsvSource({"cat, CAT", "dog, DOG", "DESSeRTS, DESSERTS", "121, 121"})
    void testUppercaseConversion(String input, String expected) {
        assertEquals(expected, classUnderTest.convertToUppercase(input));
    }
    @ParameterizedTest
    @CsvSource({"HelloWorld, helloworld", "JUnit5, junit5", "PARAMETERIZEDTESTS, parameterizedtests", "121, 121"})
    void testLowercaseConversion(String input, String expected) {
        assertEquals(expected, classUnderTest.convertToLowercase(input));
    }

    @BeforeEach
    public void initSetup() {
        classUnderTest = new CustomStringUtils();
    }

    @RepeatedTest(value = 2, name = "Current Repeated Test number:{currentRepetition}")
    public void testRepeatedTestExample() {
        System.out.println("Repeated Test");
    }
}
