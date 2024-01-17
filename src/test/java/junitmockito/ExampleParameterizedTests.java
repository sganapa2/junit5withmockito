package junitmockito;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.mockito.EmployeeService;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExampleParameterizedTests {
    @ParameterizedTest
    @ValueSource(ints = {1, 0, -2, 2})
    public void testCalculateSalary(int numberOfDays) {
        EmployeeService service = new EmployeeService();
        int result = service.calculateDoubleSalary(numberOfDays);
        if (numberOfDays <= 0) {
            assertEquals(1, result);
        } else {
            assertEquals(numberOfDays * 2, result);
        }
    }

    @ParameterizedTest
    @EnumSource(Day.class)
    void testWeekDay(Day day) {
        if (day.isWeekDay())
            assertTrue(day.isWeekDay(), day + " should be a weekday.");
    }
    enum Day { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
        boolean isWeekDay() {
            return this != SATURDAY && this != SUNDAY;
        }
    }


    // Define a static method to provide parameters
    static Stream<Arguments> inputTestCaseData() {
        return Stream.of(
                Arguments.of(2, 3, 5),   // Test Case 1
                Arguments.of(0, 0, 0),   // Test Case 2
                Arguments.of(-1, 1, 0)   // Test Case 3
        );
    }

    @ParameterizedTest
    @MethodSource("inputTestCaseData")
    void testWithMethodSource(int a, int b, int expectedResult) {
        assertEquals(a+b, expectedResult);
    }

}
