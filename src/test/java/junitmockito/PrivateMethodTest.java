package junitmockito;

import org.junit.Test;
import org.junit.mockito.PrivateMethodTestingClass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;

public class PrivateMethodTest {

    @Test
    public void privateMethodTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        PrivateMethodTestingClass underTest = new PrivateMethodTestingClass();
        String result = underTest.privateMathodCaller("UserInput");
        assertEquals("Processed out from private method for input UserInput", result);

        PrivateMethodTestingClass spyObject = spy(underTest);

        // Use reflection to access the private method
        Method reflectedPrivateMethod = PrivateMethodTestingClass.class.getDeclaredMethod("privateMethod", String.class);
        reflectedPrivateMethod.setAccessible(true);

        // Mock the behavior of the private method
       // when(reflectedPrivateMethod.invoke(spyObject, "UserInput")).thenReturn("Mocked Input");


        // Call the public method, which in turn calls the private method
        result = spyObject.privateMathodCaller("UserInput");


        assertEquals("Processed out from private method for input UserInput", result);

    }
}
