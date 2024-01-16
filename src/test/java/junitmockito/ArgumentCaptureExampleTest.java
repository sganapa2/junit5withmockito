package junitmockito;


import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ArgumentCaptureExampleTest {

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
}
