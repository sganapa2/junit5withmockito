package junitmockito;

import org.junit.jupiter.api.Test;
import org.junit.mockito.EmployeeService;
import org.junit.mockito.FinalClassExample;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FinalClassAndStaticMethodsExampleWithMockInlineTest {
    private final String mockedResponseMessage = "This is mocked message, it is not an original message.";
    @Test
    public void testFinalClassMethod() {
        FinalClassExample mockFinalClass = Mockito.mock(FinalClassExample.class);
        when(mockFinalClass.getTestMessage()).thenReturn(mockedResponseMessage);
        String result = mockFinalClass.getTestMessage();
        System.out.println("Result in test1: " + result);
        assertEquals(mockedResponseMessage, result);
    }

    @Test
    public void testFinalMethod() {
        EmployeeService mockEmployeeService = Mockito.mock(EmployeeService.class);
        when(mockEmployeeService.finalMethod()).thenReturn(mockedResponseMessage);
        String result = mockEmployeeService.finalMethod();
        System.out.println("Result in test2: " + result);
        assertEquals(mockedResponseMessage, result);
    }

    @Test
    public void testStaticMethod() {
        MockedStatic<EmployeeService> mockedStaticEmployeeService = mockStatic(EmployeeService.class);
        mockedStaticEmployeeService.when(EmployeeService::staticMethod).thenReturn(mockedResponseMessage);
        String result = EmployeeService.staticMethod();
        System.out.println("Result in test3: " + result);
        assertEquals(mockedResponseMessage, result);
        mockedStaticEmployeeService.verify(EmployeeService::staticMethod, times(1));
    }
}
