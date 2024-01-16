package junitmockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class ParallelTestExampleWithSureFirePluginTest {

    @Test
    public void testMethod1() {
        System.out.println("TestMethod1 running on Thread: " + Thread.currentThread().getId());
        assertEquals(2, 1+1);
        System.out.println("END TestMethod1");
    }

    @Test
    public void testMethod2() {
        System.out.println("TestMethod2 running on Thread: " + Thread.currentThread().getId());
        assertEquals(3, 4-1);
        System.out.println("END TestMethod2");
    }
}
