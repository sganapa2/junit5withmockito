package junitmockito;


import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.mockito.DatabaseService;
import org.junit.mockito.Employee;
import org.junit.mockito.EmployeeService;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ArgumentCaptureExampleTest {


    /*@Captor
    private ArgumentCaptor<Employee> employeeArgCaptor;*/

    @Test
        void testArgumentCapture() {
            // Create a mock of the ExampleClass
            ExampleClass mockExample = mock(ExampleClass.class);

            // Create argument captors for String and Integer
            ArgumentCaptor<String> stringArgCaptor = ArgumentCaptor.forClass(String.class);
            ArgumentCaptor<Integer> intArgCaptor = ArgumentCaptor.forClass(Integer.class);

            // Perform the method invocation on the mock with specific arguments
            mockExample.exampleMethod("Hello", 42);

            // Capture the arguments using the captors
            verify(mockExample).exampleMethod(stringArgCaptor.capture(), intArgCaptor.capture());

            // Assert the captured values
            assertEquals("Hello", stringArgCaptor.getValue());
            assertEquals(42, intArgCaptor.getValue());
            assertEquals("Hello", stringArgCaptor.getAllValues().get(0));
            assertEquals(42, intArgCaptor.getAllValues().get(0));
        }

        // Example class with a method to be mocked
        static class ExampleClass {
            void exampleMethod(String strArg, int intArg) {
                // Some implementation
            }
        }


        @Test
        public void testDeleteEmployeeEntry() {
            Employee employeeToDelete = getTestEmployee();
            DatabaseService mockDBService = mock(DatabaseService.class);
            ArgumentCaptor<Employee> employeeArgCaptor = ArgumentCaptor.forClass(Employee.class);
            EmployeeService employeeServiceUnderTest = new EmployeeService(mockDBService);

            employeeServiceUnderTest.deleteEmployeeEntry(employeeToDelete);
            verify(mockDBService).deleteEmployee(employeeArgCaptor.capture());
            val capturedEmployee = employeeArgCaptor.getValue();
            assertEquals(1, capturedEmployee.getEmployeeId());
            assertEquals("Sharad", capturedEmployee.getName());
        }

        private Employee getTestEmployee() {
            Employee employeeToDelete = new Employee();
            employeeToDelete.setEmployeeId(1);
            employeeToDelete.setName("Sharad");
            employeeToDelete.setSalary(100000);
            return employeeToDelete;
        }
}
