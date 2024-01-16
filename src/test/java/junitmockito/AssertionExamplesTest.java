package junitmockito;

import org.junit.jupiter.api.Test;
import org.junit.mockito.EmployeeService;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionExamplesTest {

    @Test
    public void testAssertions() {
        assertEquals(4, 2 + 2);
        assertTrue(true);
        assertFalse(false);
        assertNotNull("not null");
        assertNull(null);

        String original = "Hello";
        String reference = original;
        String different = new String("Hello");

        assertSame(original, reference, "References should point to the same object");
        assertNotSame(original, different, "References should point to different objects");

        int[] expected = {1, 2, 3};
        int[] actual = {1, 2, 3};

        assertArrayEquals(expected, actual, "Arrays should be equal");
    }

    @Test
    void testOperationWithinTimeout() {
        assertTimeout(ofSeconds(2), () -> {
            // A time-consuming operation that completes within 2 seconds,
            // for example, 3rd party API call, DB call
            Thread.sleep(1900);
        });
    }

    @Test
    void testDoesNotThrowNullPointerException() {
        String str = "JUnit 5";
        assertDoesNotThrow(() -> {
            int length = str.length(); // This should not throw any exception
        });
    }

    @Test
    void testNullPointerException() {
        String str = null;
        assertThrows(NullPointerException.class, () -> {
            int length = str.length(); // This should throw NullPointerException
        });
    }

    @Test
    public void testIsDoubleSalaryWithAssertAll() {
        EmployeeService employeeService = new EmployeeService();
        assertAll("Is Salary Double Test",
                () -> assertEquals(2, employeeService.calculateDoubleSalary(1)),
                () -> assertEquals(4, employeeService.calculateDoubleSalary(2))
                );
    }

}
