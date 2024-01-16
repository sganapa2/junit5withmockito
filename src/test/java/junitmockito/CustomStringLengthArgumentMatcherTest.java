package junitmockito;

import org.junit.jupiter.api.Test;
import org.junit.mockito.EmployeeService;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomStringLengthArgumentMatcherTest implements ArgumentMatcher<String> {
    @Override
    public boolean matches(String argument) {
        return argument.length() > 10;
    }

    public String method(String s) {
        return s;
    }

    @Test
    public void testCustomArgMatcherWithArgThat() {
        CustomStringLengthArgumentMatcherTest underTest = mock(CustomStringLengthArgumentMatcherTest.class);
        when(underTest.method(argThat(new CustomStringLengthArgumentMatcherTest()))).thenReturn("lengthyString");

        //assertTrue(underTest.method("lengthyString"));
    }

    @Test
    public void testMockingDetails() {
        EmployeeService mockEmployeeService = mock(EmployeeService.class, Mockito.RETURNS_MOCKS);
        assertTrue(Mockito.mockingDetails(mockEmployeeService).isMock());
        assertFalse(Mockito.mockingDetails(mockEmployeeService).isSpy());
    }
}
