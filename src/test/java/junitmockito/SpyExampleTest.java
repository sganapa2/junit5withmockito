package junitmockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.mockito.DatabaseService;
import org.junit.mockito.EmployeeService;
import org.mockito.Spy;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SpyExampleTest {

    EmployeeService employeeService;

    @BeforeEach
    public void initializeMock() {
        mockitoSession().startMocking();
    }

    @Test
    public void testWithSpyExample() {
        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> hashMapSpy = spy(hashMap);

        System.out.println(hashMapSpy.get("key")); // Will print null.
        hashMapSpy.put("key", "A value");
        System.out.println(hashMapSpy.get("key")); // Will print "A value".
        when(hashMapSpy.get("key")).thenReturn("Another mocked value");
        System.out.println(hashMapSpy.get("key")); // Will print "Another mocked value".
    }

    @Spy
    private DatabaseService databaseServiceSpy;

    @Test
    public void testDataFromDb() {
        databaseServiceSpy = spy(new DatabaseService());
        employeeService = new EmployeeService(databaseServiceSpy);
        // Stubbing specific method in the spy
        when(databaseServiceSpy.query("input query")).thenReturn("Mocked result");
        //doReturn("Mocked result").when(databaseServiceSpy).query("input query");

        // Test the employee service logic without hitting the actual database
        // The query method of the spy will return the mocked result
        assertEquals("Mocked result", employeeService.getDataFromDB("input query"));


    }
}
